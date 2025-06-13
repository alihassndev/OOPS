package library;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RegisterScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public RegisterScreen() {
        setTitle("Library Management System - Register");
        UIConstants.setUIDefaults();
        UIConstants.setupFrame(this);
        UIConstants.applyBackground(this, UIConstants.REGISTER_BG);

        // Main panel with some opacity for better text visibility
        JPanel mainPanel = UIConstants.createTransparentPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title panel with icon
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        JLabel iconLabel = new JLabel(new ImageIcon(UIConstants.BOOK_ICON));
        JLabel titleLabel = new JLabel("Register New User");
        titleLabel.setFont(UIConstants.TITLE_FONT);
        titleLabel.setForeground(UIConstants.TEXT_COLOR);

        titlePanel.add(iconLabel);
        titlePanel.add(titleLabel);

        // Input fields
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        roleComboBox = new JComboBox<>(new String[] { "User", "Admin" });

        // Style input fields
        usernameField.setPreferredSize(UIConstants.TEXT_FIELD_SIZE);
        passwordField.setPreferredSize(UIConstants.TEXT_FIELD_SIZE);
        roleComboBox.setPreferredSize(UIConstants.TEXT_FIELD_SIZE);

        // Buttons
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Login");

        UIConstants.styleButton(registerButton);
        UIConstants.styleButton(backButton);

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(UIConstants.PADDING, UIConstants.PADDING, UIConstants.PADDING, UIConstants.PADDING);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titlePanel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Role:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(roleComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(registerButton, gbc);

        gbc.gridy = 5;
        mainPanel.add(backButton, gbc);

        // Add main panel to frame
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(mainPanel);
        add(wrapperPanel);

        // Event handlers
        registerButton.addActionListener(e -> handleRegister());
        backButton.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            dispose();
        });

        // Add enter key listener for registration
        getRootPane().setDefaultButton(registerButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void handleRegister() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            UIConstants.showError(this, "Please fill in all fields");
            return;
        }

        if (FileHandler.userExists(username, role)) {
            UIConstants.showError(this, "Username already exists");
            return;
        }

        User newUser = new User(username, password, role);
        if (FileHandler.writeUser(newUser, "users.txt")) {
            UIConstants.showSuccess(this, "Registration successful!");
            new LoginScreen().setVisible(true);
            dispose();
        } else {
            UIConstants.showError(this, "Failed to register user. Please try again.");
        }
    }
}
