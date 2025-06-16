package library;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class FileHandler {
    private static final String USERS_FILE = "users.txt";
    private static final String BOOKS_FILE = "books.txt";
    private static final String ISSUED_FILE = "issued.txt";
    private static final String HISTORY_FILE = "history.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static List<User> readUsers(String filename) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(User.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No user file found.");
        }
        return users;
    }

    public static boolean userExists(String username, String role) {
        List<User> users = readUsers(USERS_FILE);
        return users.stream()
                .anyMatch(user -> user.getUsername().equalsIgnoreCase(username)
                        && user.getRole().equalsIgnoreCase(role));
    }

    public static boolean writeUser(User user, String filename) {
        if (userExists(user.getUsername(), user.getRole())) {
            return false;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(user.toString());
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static boolean bookExists(String bookId) {
        List<Book> books = readBooks();
        return books.stream()
                .anyMatch(book -> book.getId().equals(bookId));
    }

    public static boolean writeBook(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE, true))) {
            writer.write(book.toFileString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void updateBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isBookIssued(String bookId) {
        try (BufferedReader br = new BufferedReader(new FileReader(ISSUED_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(bookId)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("No issued books file found.");
        }
        return false;
    }

    public static void writeIssuedBook(String userId, String bookId) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ISSUED_FILE, true))) {
            String timestamp = DATE_FORMAT.format(new Date());
            bw.write(userId + "," + bookId + "," + timestamp);
            bw.newLine();

            // Add to history
            Book book = findBookById(bookId);
            if (book != null) {
                BookHistory history = new BookHistory(
                        bookId,
                        book.getTitle(),
                        LocalDate.now(),
                        null,
                        "BORROWED");
                writeToHistory(history);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(String userId, String bookId) {
        List<String> remainingIssues = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ISSUED_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains(userId + "," + bookId)) {
                    remainingIssues.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("No issued books file found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ISSUED_FILE))) {
            for (String issue : remainingIssues) {
                bw.write(issue);
                bw.newLine();
            }

            // Add to history
            String timestamp = DATE_FORMAT.format(new Date());
            Book book = findBookById(bookId);
            if (book != null) {
                BookHistory history = new BookHistory(
                        bookId,
                        book.getTitle(),
                        LocalDate.now(),
                        LocalDate.now(),
                        "RETURNED");
                writeToHistory(history);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BookHistory> getUserHistory(String userId) {
        List<BookHistory> history = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    Book book = findBookById(parts[0]);
                    if (book != null) {
                        history.add(new BookHistory(
                                parts[0], // bookId
                                parts[1], // bookTitle
                                LocalDate.parse(parts[3].split(" ")[0]), // borrowDate
                                parts[2].equals("RETURNED") ? LocalDate.parse(parts[3].split(" ")[0]) : null, // returnDate
                                parts[2] // status
                        ));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No history file found.");
        }
        return history;
    }

    private static Book findBookById(String bookId) {
        List<Book> books = readBooks();
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public static void writeToHistory(BookHistory history) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            String timestamp = DATE_FORMAT.format(new Date());
            bw.write(String.format("%s,%s,%s,%s",
                    history.getBookId(),
                    history.getBookTitle(),
                    history.getStatus(),
                    timestamp));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getIssuedBooks(String username) {
        List<Book> issuedBooks = new ArrayList<>();
        List<String> issuedLines = readLines(ISSUED_FILE);
        List<Book> allBooks = readBooks();

        for (String line : issuedLines) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[1].equals(username)) {
                String bookId = parts[0];
                // Find the book in all books
                for (Book book : allBooks) {
                    if (book.getId().equals(bookId)) {
                        issuedBooks.add(book);
                        break;
                    }
                }
            }
        }

        return issuedBooks;
    }

    public static User validateUser(String username, String password, String role) {
        List<User> users = readUsers("users.txt");
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equalsIgnoreCase(role)) {
                return user;
            }
        }
        return null;
    }

    public static void removeBook(String bookId) {
        List<Book> books = readBooks();
        books.removeIf(book -> book.getId().equals(bookId));

        updateBooks(books);
    }

    public static boolean isBookIssuedToUser(String bookId, String username) {
        List<String> lines = readLines(ISSUED_FILE);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[0].equals(bookId) && parts[1].equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean returnBook(String bookId) {
        List<String> lines = readLines(ISSUED_FILE);
        List<String> updatedLines = new ArrayList<>();
        boolean found = false;

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[0].equals(bookId)) {
                found = true;
                // Add to history
                String username = parts[1];
                Book book = findBookById(bookId);
                if (book != null) {
                    BookHistory history = new BookHistory(
                            bookId,
                            book.getTitle(),
                            LocalDate.now(),
                            LocalDate.now(),
                            "RETURNED");
                    writeToHistory(history);
                }
            } else {
                updatedLines.add(line);
            }
        }

        if (!found) {
            return false;
        }

        // Update issued books file
        writeLines(ISSUED_FILE, updatedLines);
        return true;
    }

    private static List<String> readLines(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void writeLines(String filename, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        List<String> lines = readLines(BOOKS_FILE);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                books.add(new Book(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3])));
            }
        }
        return books;
    }

    public static boolean isBookAvailable(String bookId) {
        List<String> lines = readLines(BOOKS_FILE);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 4 && parts[0].equals(bookId)) {
                return Boolean.parseBoolean(parts[3]);
            }
        }
        return false;
    }

    public static boolean issueBook(String bookId, String username) {
        if (!isBookAvailable(bookId)) {
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ISSUED_FILE, true))) {
            String timestamp = DATE_FORMAT.format(new Date());
            bw.write(bookId + "," + username + "," + timestamp);
            bw.newLine();

            // Add to history
            Book bookToIssue = findBookById(bookId);
            if (bookToIssue != null) {
                BookHistory history = new BookHistory(
                        bookId,
                        bookToIssue.getTitle(),
                        LocalDate.now(),
                        null,
                        "BORROWED");
                writeToHistory(history);
            }

            // Update book availability
            List<Book> books = readBooks();
            for (Book book : books) {
                if (book.getId().equals(bookId)) {
                    book.setAvailable(false);
                    break;
                }
            }
            updateBooks(books);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
