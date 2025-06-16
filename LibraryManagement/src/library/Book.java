package library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;

    public Book(String id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nTitle: %s\nAuthor: %s\nAvailable: %s",
                id, title, author, available ? "Yes" : "No");
    }

    public static Book fromString(String line) {
        String[] parts = line.split(",");
        // Handle both old format (3 fields) and new format (4 fields)
        boolean available = parts.length > 3 ? Boolean.parseBoolean(parts[3]) : true;
        return new Book(parts[0], parts[1], parts[2], available);
    }

    public static List<Book> fromFileStrings(List<String> lines) {
        List<Book> books = new ArrayList<>();
        for (String line : lines) {
            books.add(fromString(line));
        }
        return books;
    }

    public String toFileString() {
        return String.format("%s,%s,%s,%s", id, title, author, available);
    }
}
