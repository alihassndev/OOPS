package library;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public LoginScreen() {
        setTitle("Library Management System - Login");
        UIConstants.setUIDefaults();
        UIConstants.setupFrame(this);
        UIConstants.applyBackground(this, UIConstants.LOGIN_BG);

        // Main panel with some opacity for better text visibility
        JPanel mainPanel = UIConstants.createTransparentPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title panel with icon
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        JLabel iconLabel = new JLabel(new ImageIcon(UIConstants.BOOK_ICON));
        JLabel titleLabel = new JLabel("Library Management System");
        titleLabel.setFont(UIConstants.TITLE_FONT);
        titleLabel.setForeground(UIConstants.TEXT_COLOR);

        titlePanel.add(iconLabel);
        titlePanel.add(titleLabel);

        // Input fields
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        roleComboBox = new JComboBox<>(new String[] { "User", "Admin" });

        // Style input fields
        usernameField.setPreferredSize(new Dimension(250, 30));
        passwordField.setPreferredSize(new Dimension(250, 30));
        roleComboBox.setPreferredSize(new Dimension(250, 30));

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register New User");

        UIConstants.styleButton(loginButton);
        UIConstants.styleButton(registerButton);

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
        mainPanel.add(loginButton, gbc);

        gbc.gridy = 5;
        mainPanel.add(registerButton, gbc);

        // Add main panel to frame
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(mainPanel);
        add(wrapperPanel);

        // Event handlers
        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> {
            new RegisterScreen().setVisible(true);
            dispose();
        });

        // Add enter key listener for login
        getRootPane().setDefaultButton(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            UIConstants.showError(this, "Please fill in all fields");
            return;
        }

        User user = FileHandler.validateUser(username, password, role);
        if (user == null) {
            UIConstants.showError(this, "Invalid username, password, or role");
            return;
        }

        if (role.equals("Admin")) {
            new AdminDashboard().setVisible(true);
        } else {
            new UserDashboard(user).setVisible(true);
        }
        dispose();
    }
}
