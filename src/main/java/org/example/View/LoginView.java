package org.example.View;
import javax.swing.*;

public class LoginView extends JFrame {
    private JPanel panel;
    private JLabel nombre;
    private JTextField textField1;
    private JButton ingresarButton;
    private JPasswordField passwordField1;
    private JLabel registroLink;
    private JLabel recuperaPassword;
    private JLabel contra;

    public LoginView() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}