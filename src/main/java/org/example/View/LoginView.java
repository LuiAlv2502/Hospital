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
        passwordField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));


        // Hacer que el registroLink se vea como hipervínculo
        registroLink.setText("<html><a href=''>Registrarse</a></html>");
        registroLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        recuperaPassword.setText("<html><a href=''>¿Olvidaste tu contraseña?</a></html>");
        recuperaPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
    public JTextField getTxtName() { return textField1; }
    public JPasswordField getTxtPassword() { return passwordField1; }
    public JButton getBtnLogin() { return ingresarButton; }
    public JLabel getRegistroLink() { return registroLink; }
    public JLabel getRecuperaPassword() { return recuperaPassword; }

}