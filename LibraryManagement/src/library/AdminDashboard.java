package library;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class AdminDashboard extends JFrame {
    private JTextArea bookListArea;
    private JTextField bookIdField;
    private JTextField titleField;
    private JTextField authorField;
    private JTabbedPane tabbedPane;

    public AdminDashboard() {
        setTitle("Library Management System - Admin Dashboard");
        UIConstants.setUIDefaults();
        UIConstants.setupFrame(this);
        UIConstants.applyBackground(this, UIConstants.DASHBOARD_BG);

        // Main panel with some opacity for better text visibility
        JPanel mainPanel = UIConstants.createTransparentPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setFont(UIConstants.TITLE_FONT);
        titleLabel.setForeground(UIConstants.TEXT_COLOR);
        titlePanel.add(titleLabel);

        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setOpaque(false);
        tabbedPane.setBackground(new Color(255, 255, 255, 200));

        // Books Management Tab
        JPanel booksPanel = createBooksPanel();
        tabbedPane.addTab("Books Management", new ImageIcon(UIConstants.BOOK_ICON), booksPanel);

        // Users Management Tab
        JPanel usersPanel = createUsersPanel();
        tabbedPane.addTab("Users Management", new ImageIcon(UIConstants.USER_ICON), usersPanel);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        UIConstants.styleButton(logoutButton);
        logoutButton.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            dispose();
        });

        // Layout
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(logoutButton, BorderLayout.SOUTH);

        // Add main panel to frame
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(mainPanel);
        add(wrapperPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createBooksPanel() {
        JPanel panel = UIConstants.createTransparentPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input fields panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Book ID field
        bookIdField = new JTextField(20);
        bookIdField.setPreferredSize(UIConstants.TEXT_FIELD_SIZE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Book ID:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(bookIdField, gbc);

        // Title field
        titleField = new JTextField(20);
        titleField.setPreferredSize(UIConstants.TEXT_FIELD_SIZE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(titleField, gbc);

        // Author field
        authorField = new JTextField(20);
        authorField.setPreferredSize(UIConstants.TEXT_FIELD_SIZE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Author:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(authorField, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setOpaque(false);

        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book");
        JButton refreshButton = new JButton("Refresh List");

        UIConstants.styleButton(addButton);
        UIConstants.styleButton(removeButton);
        UIConstants.styleButton(refreshButton);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(refreshButton);

        // Book list area
        bookListArea = new JTextArea(10, 40);
        bookListArea.setEditable(false);
        bookListArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        bookListArea.setBackground(new Color(255, 255, 255, 230));
        bookListArea.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(bookListArea);
        scrollPane.setPreferredSize(UIConstants.SCROLL_PANE_SIZE);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.GRAY)));

        // Layout
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setOpaque(false);
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Event handlers
        addButton.addActionListener(e -> handleAddBook());
        removeButton.addActionListener(e -> handleRemoveBook());
        refreshButton.addActionListener(e -> refreshBookList());

        refreshBookList();
        return panel;
    }

    private JPanel createUsersPanel() {
        JPanel panel = UIConstants.createTransparentPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Users list area
        JTextArea usersArea = new JTextArea(10, 40);
        usersArea.setEditable(false);
        usersArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        usersArea.setBackground(new Color(255, 255, 255, 230));
        usersArea.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(usersArea);
        scrollPane.setPreferredSize(UIConstants.SCROLL_PANE_SIZE);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.GRAY)));

        // Refresh button
        JButton refreshButton = new JButton("Refresh Users List");
        UIConstants.styleButton(refreshButton);
        refreshButton.addActionListener(e -> refreshUsersList(usersArea));

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(refreshButton, BorderLayout.SOUTH);

        refreshUsersList(usersArea);
        return panel;
    }

    private void refreshBookList() {
        List<Book> books = FileHandler.readBooks();
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

    private void refreshUsersList(JTextArea area) {
        List<User> users = FileHandler.readUsers("users.txt");
        StringBuilder sb = new StringBuilder();
        sb.append("Registered Users:\n");
        sb.append(String.format("%-20s %-10s\n", "Username", "Role"));
        sb.append("--------------------------------------------------------------------------------\n");

        for (User user : users) {
            sb.append(String.format("%-20s %-10s\n",
                    user.getUsername(),
                    user.getRole()));
        }
        area.setText(sb.toString());
        area.setCaretPosition(0);
    }

    private void handleAddBook() {
        String id = bookIdField.getText().trim();
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();

        if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
            UIConstants.showError(this, "Please fill in all fields");
            return;
        }

        if (FileHandler.bookExists(id)) {
            UIConstants.showError(this, "A book with this ID already exists");
            return;
        }

        Book newBook = new Book(id, title, author, true);
        if (FileHandler.writeBook(newBook)) {
            UIConstants.showSuccess(this, "Book added successfully!");
            bookIdField.setText("");
            titleField.setText("");
            authorField.setText("");
            refreshBookList();
        } else {
            UIConstants.showError(this, "Failed to add book. Please try again.");
        }
    }

    private void handleRemoveBook() {
        String bookId = JOptionPane.showInputDialog(this, "Enter Book ID to remove:");
        if (bookId == null || bookId.trim().isEmpty()) {
            return;
        }

        bookId = bookId.trim();

        if (!FileHandler.bookExists(bookId)) {
            UIConstants.showError(this, "Book not found");
            return;
        }

        if (!FileHandler.isBookAvailable(bookId)) {
            UIConstants.showError(this, "Cannot remove an issued book");
            return;
        }

        FileHandler.removeBook(bookId);
        UIConstants.showSuccess(this, "Book removed successfully!");
        refreshBookList();
    }
}
