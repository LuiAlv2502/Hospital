package org.example.View;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JPanel panel;
    private JLabel nombre;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;

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