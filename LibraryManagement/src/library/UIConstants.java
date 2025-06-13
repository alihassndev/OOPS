package library;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UIConstants {
    // Screen dimensions
    public static final int MIN_SCREEN_WIDTH = 800;
    public static final int MIN_SCREEN_HEIGHT = 600;
    public static final int DEFAULT_SCREEN_WIDTH = 900;
    public static final int DEFAULT_SCREEN_HEIGHT = 650;

    // Colors
    public static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    public static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    public static final Color TEXT_COLOR = new Color(44, 62, 80);
    public static final Color BACKGROUND_COLOR = new Color(236, 240, 241);

    // Fonts
    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font TEXT_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font NORMAL_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    // Margins and padding
    public static final int MARGIN = 15;
    public static final int PADDING = 8;

    // Component dimensions
    public static final Dimension BUTTON_SIZE = new Dimension(120, 35);
    public static final Dimension TEXT_FIELD_SIZE = new Dimension(200, 30);
    public static final Dimension SCROLL_PANE_SIZE = new Dimension(600, 300);

    // Image paths
    public static final String LOGIN_BG = "images/login_bg.jpg";
    public static final String REGISTER_BG = "images/register_bg.jpg";
    public static final String DASHBOARD_BG = "images/dashboard_bg.jpg";
    public static final String BOOK_ICON = "images/book_icon.png";
    public static final String USER_ICON = "images/user_icon.png";

    // Image URLs for download
    public static final String[] IMAGE_URLS = {
            "https://images.unsplash.com/photo-1507842217343-583bb7270b66?w=1024&h=768&fit=crop",
            "https://images.unsplash.com/photo-1521587760476-6c12a4b040da?w=1024&h=768&fit=crop",
            "https://images.unsplash.com/photo-1507842217343-583bb7270b66?w=1024&h=768&fit=crop",
            "https://cdn-icons-png.flaticon.com/512/2232/2232688.png",
            "https://cdn-icons-png.flaticon.com/512/1077/1077114.png"
    };

    public static void setUIDefaults() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setupFrame(JFrame frame) {
        frame.setSize(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
        frame.setMinimumSize(new Dimension(MIN_SCREEN_WIDTH, MIN_SCREEN_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        centerFrame(frame);
    }

    public static void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    public static void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showSuccess(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void applyBackground(JFrame frame, String imagePath) {
        try {
            ImageIcon backgroundImage = new ImageIcon(imagePath);
            Image scaledImage = backgroundImage.getImage().getScaledInstance(
                    frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
            backgroundImage = new ImageIcon(scaledImage);

            JLabel background = new JLabel(backgroundImage);
            background.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            frame.getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));

            JPanel contentPane = (JPanel) frame.getContentPane();
            contentPane.setOpaque(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel createTransparentPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(255, 255, 255, 200));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
    }

    public static void styleButton(JButton button) {
        button.setFont(NORMAL_FONT);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(BUTTON_SIZE);
    }

    public static Dimension getScaledDimension(int width, int height, int maxWidth, int maxHeight) {
        double ratio = Math.min(
                (double) maxWidth / width,
                (double) maxHeight / height);
        return new Dimension(
                (int) (width * ratio),
                (int) (height * ratio));
    }
}