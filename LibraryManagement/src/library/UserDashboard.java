package library;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Comparator;

public class UserDashboard extends JFrame {
    private User user;
    private JTextArea issuedBooksArea;
    private JTextArea historyArea;
    private JTextArea bookListArea;
    private JTextField bookIdField;
    private JTabbedPane tabbedPane;

    public UserDashboard(User user) {
        this.user = user;
        setTitle("Library Management System - User Dashboard");
        UIConstants.setUIDefaults();
        UIConstants.setupFrame(this);
        UIConstants.applyBackground(this, UIConstants.DASHBOARD_BG);

        // Main panel with some opacity for better text visibility
        JPanel mainPanel = UIConstants.createTransparentPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title panel with icon
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        JLabel iconLabel = new JLabel(new ImageIcon(UIConstants.USER_ICON));
        JLabel titleLabel = new JLabel("Welcome, " + user.getUsername());
        titleLabel.setFont(UIConstants.TITLE_FONT);
        titleLabel.setForeground(UIConstants.TEXT_COLOR);

        titlePanel.add(iconLabel);
        titlePanel.add(titleLabel);

        // Create text areas
        issuedBooksArea = new JTextArea(10, 40);
        historyArea = new JTextArea(10, 40);

        issuedBooksArea.setEditable(false);
        historyArea.setEditable(false);

        issuedBooksArea.setFont(UIConstants.TEXT_FONT);
        historyArea.setFont(UIConstants.TEXT_FONT);

        JScrollPane issuedScrollPane = new JScrollPane(issuedBooksArea);
        JScrollPane historyScrollPane = new JScrollPane(historyArea);

        issuedScrollPane.setPreferredSize(UIConstants.SCROLL_PANE_SIZE);
        historyScrollPane.setPreferredSize(UIConstants.SCROLL_PANE_SIZE);

        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(UIConstants.NORMAL_FONT);
        tabbedPane.setOpaque(false);

        // Available Books tab
        JPanel availableBooksPanel = new JPanel(new BorderLayout(10, 10));
        availableBooksPanel.setOpaque(false);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);

        JLabel searchLabel = new JLabel("Search by Title:");
        searchLabel.setFont(UIConstants.NORMAL_FONT);
        bookIdField = new JTextField(20);
        bookIdField.setFont(UIConstants.NORMAL_FONT);

        JButton searchButton = new JButton("Search");
        JButton refreshButton = new JButton("Refresh List");

        UIConstants.styleButton(searchButton);
        UIConstants.styleButton(refreshButton);

        searchPanel.add(searchLabel);
        searchPanel.add(bookIdField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);

        bookListArea = new JTextArea(20, 40);
        bookListArea.setEditable(false);
        bookListArea.setFont(UIConstants.TEXT_FONT);

        JScrollPane bookScrollPane = new JScrollPane(bookListArea);
        bookScrollPane.setPreferredSize(UIConstants.SCROLL_PANE_SIZE);

        availableBooksPanel.add(searchPanel, BorderLayout.NORTH);
        availableBooksPanel.add(bookScrollPane, BorderLayout.CENTER);

        // Issued Books tab
        JPanel issuedBooksPanel = new JPanel(new BorderLayout(10, 10));
        issuedBooksPanel.setOpaque(false);
        issuedBooksPanel.add(issuedScrollPane, BorderLayout.CENTER);

        // History tab
        JPanel historyPanel = new JPanel(new BorderLayout(10, 10));
        historyPanel.setOpaque(false);
        historyPanel.add(historyScrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Available Books", availableBooksPanel);
        tabbedPane.addTab("Issued Books", issuedBooksPanel);
        tabbedPane.addTab("History", historyPanel);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.setOpaque(false);

        JButton issueButton = new JButton("Issue Book");
        JButton returnButton = new JButton("Return Book");
        JButton logoutButton = new JButton("Logout");

        UIConstants.styleButton(issueButton);
        UIConstants.styleButton(returnButton);
        UIConstants.styleButton(logoutButton);

        buttonPanel.add(issueButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(logoutButton);

        // Add components to main panel using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add title panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titlePanel, gbc);

        // Add tabbed pane
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(tabbedPane, gbc);

        // Add button panel
        gbc.gridy = 2;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(buttonPanel, gbc);

        // Add main panel to frame
        add(mainPanel);

        // Event handlers
        searchButton.addActionListener(e -> handleSearch());
        refreshButton.addActionListener(e -> refreshBookList());
        issueButton.addActionListener(e -> handleIssueBook());
        returnButton.addActionListener(e -> handleReturnBook());
        logoutButton.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            dispose();
        });

        // Add enter key listener for search
        bookIdField.addActionListener(e -> handleSearch());

        // Initial data load
        refreshData();
        refreshBookList();
    }

    private void handleSearch() {
        String searchTitle = bookIdField.getText().trim().toLowerCase();
        if (searchTitle.isEmpty()) {
            refreshBookList();
            return;
        }

        List<Book> books = FileHandler.getBooks();
        StringBuilder result = new StringBuilder();
        result.append("Search Results:\n");
        result.append(String.format("%-10s %-30s %-20s %-10s\n", "ID", "Title", "Author", "Status"));
        result.append("--------------------------------------------------------------------------------\n");
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle)) {
                result.append(String.format("%-10s %-30s %-20s %-10s\n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.isAvailable() ? "Available" : "Issued"));
                found = true;
            }
        }

        if (!found) {
            result.append("No books found matching: ").append(searchTitle);
        }

        bookListArea.setText(result.toString());
    }

    private void handleIssueBook() {
        String bookId = JOptionPane.showInputDialog(this, "Enter Book ID to issue:");
        if (bookId == null || bookId.trim().isEmpty()) {
            return;
        }

        bookId = bookId.trim();

        // Check if book exists
        if (!FileHandler.bookExists(bookId)) {
            UIConstants.showError(this, "Book not found");
            return;
        }

        // Check if book is available
        if (!FileHandler.isBookAvailable(bookId)) {
            UIConstants.showError(this, "Book is not available");
            return;
        }

        // Issue the book
        if (FileHandler.issueBook(bookId, user.getUsername())) {
            UIConstants.showSuccess(this, "Book issued successfully!");
            refreshData();
            refreshBookList();
        } else {
            UIConstants.showError(this, "Failed to issue book. Please try again.");
        }
    }

    private void refreshBookList() {
        List<Book> books = FileHandler.readBooks();
        // Sort books by Book ID (numeric)
        books.sort(Comparator.comparingInt(b -> Integer.parseInt(b.getId())));

        StringBuilder result = new StringBuilder();
        result.append("Available Books:\n");
        result.append(String.format("%-10s %-30s %-20s %-10s\n", "ID", "Title", "Author", "Status"));
        result.append("--------------------------------------------------------------------------------\n");

        for (Book book : books) {
            result.append(String.format("%-10s %-30s %-20s %-10s\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.isAvailable() ? "Available" : "Issued"));
        }

        bookListArea.setText(result.toString());
        bookListArea.setCaretPosition(0);
    }

    private void refreshIssuedBooks(JTextArea area) {
        List<Book> issuedBooks = FileHandler.getIssuedBooks(user.getUsername());
        StringBuilder sb = new StringBuilder();
        sb.append("My Issued Books:\n");
        sb.append(String.format("%-10s %-30s %-20s\n", "ID", "Title", "Author"));
        sb.append("--------------------------------------------------------------------------------\n");

        for (Book book : issuedBooks) {
            sb.append(String.format("%-10s %-30s %-20s\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor()));
        }
        area.setText(sb.toString());
        area.setCaretPosition(0);
    }

    private void refreshHistory(JTextArea area) {
        List<BookHistory> history = FileHandler.getUserHistory(user.getUsername());
        StringBuilder sb = new StringBuilder();
        sb.append("My Book History:\n");
        sb.append(String.format("%-10s %-30s %-15s %-15s\n", "Book ID", "Title",
                "Status", "Borrow Date"));
        sb.append("--------------------------------------------------------------------------------\n");

        for (BookHistory entry : history) {
            sb.append(String.format("%-10s %-30s %-15s %-15s\n",
                    entry.getBookId(),
                    entry.getBookTitle(),
                    entry.getStatus(),
                    entry.getBorrowDate()));
        }
        area.setText(sb.toString());
        area.setCaretPosition(0);
    }

    private void handleReturnBook() {
        String bookId = JOptionPane.showInputDialog(this, "Enter Book ID to return:");
        if (bookId == null || bookId.trim().isEmpty()) {
            return;
        }

        bookId = bookId.trim();

        // Check if book is issued to this user
        if (!FileHandler.isBookIssuedToUser(bookId, user.getUsername())) {
            UIConstants.showError(this, "This book is not issued to you");
            return;
        }

        // Return the book
        if (FileHandler.returnBook(bookId)) {
            UIConstants.showSuccess(this, "Book returned successfully!");
            refreshData();
            refreshBookList();
        } else {
            UIConstants.showError(this, "Failed to return book. Please try again.");
        }
    }

    private void refreshData() {
        // Refresh issued books
        List<Book> issuedBooks = FileHandler.getIssuedBooks(user.getUsername());
        StringBuilder issuedText = new StringBuilder();
        issuedText.append("Your Issued Books:\n");
        issuedText.append(String.format("%-10s %-30s %-20s\n", "ID", "Title", "Author"));
        issuedText.append("--------------------------------------------------------\n");

        for (Book book : issuedBooks) {
            issuedText.append(String.format("%-10s %-30s %-20s\n",
                    book.getId(), book.getTitle(), book.getAuthor()));
        }

        if (issuedBooks.isEmpty()) {
            issuedText.append("\nNo books currently issued to you.");
        }

        issuedBooksArea.setText(issuedText.toString());

        // Refresh history
        List<BookHistory> history = FileHandler.getUserHistory(user.getUsername());
        StringBuilder historyText = new StringBuilder();
        historyText.append("Your Book History:\n");
        historyText.append(String.format("%-10s %-30s %-15s %-15s\n", "Book ID", "Title", "Status", "Borrow Date"));
        historyText.append("--------------------------------------------------------\n");

        for (BookHistory entry : history) {
            historyText.append(String.format("%-10s %-30s %-15s %-15s\n",
                    entry.getBookId(),
                    entry.getBookTitle(),
                    entry.getStatus(),
                    entry.getBorrowDate()));
        }

        if (history.isEmpty()) {
            historyText.append("\nNo history available.");
        }

        historyArea.setText(historyText.toString());
    }
}
