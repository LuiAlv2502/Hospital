package org.example.View;
import javax.swing.*;

public class RegisterView extends JFrame{
        private JPanel panel;
    private JLabel apellidos;
    private JLabel nombre;
    private JLabel email;
    private JTextField textField1;
        private JButton ingresarButton;
        private JPasswordField passwordField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField2;
    private JButton registrarseButton;
    private JLabel contraRegistro;
    private JLabel registroLink;
        private JLabel recuperaPassword;
        private JLabel contra;

        public RegisterView() {
            setTitle("Register");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);
            add(panel);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                org.example.View.RegisterView registerView = new org.example.View.RegisterView();
                registerView.setVisible(true);
            });
        }
    }