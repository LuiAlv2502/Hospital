package org.example.View;

import javax.swing.*;

public class RegisterView extends JFrame{
    private JPanel panel;
    private JLabel apellidos;
    private JLabel nombre;
    private JLabel email;
    private JTextField nombreTextfield;
    private JButton ingresarButton;
    private JPasswordField passwordField1;
    private JTextField idtextField;
    private JTextField EspecialidadtextField;
    private JPasswordField passwordField2;
    private JButton registrarseButton;
    private JComboBox comboBoxRol;
    private JTextField Fecha;
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

    public AbstractButton getRegistrarseButton() {
        return registrarseButton;
    }



    public JComponent getRegistroLink() {
        return registroLink;
    }
    public JTextField getNombreTextfield() {
        return nombreTextfield;
    }
    public JTextField getIdtextField() {
        return idtextField;
    }
    public JTextField getEspecialidadtextField() {
        return EspecialidadtextField;
    }
    public JButton getIngresarButton() {
        return ingresarButton;
    }
    public JPasswordField getPasswordField1() {
        return passwordField1;
    }
    public JPasswordField getPasswordField2() {
        return passwordField2;
    }
    public String getComboBoxRol() {
        return comboBoxRol.getSelectedItem().toString();
    }
    public JTextField getFecha() {
        return Fecha;
    }


    public JTextField getTxtConfirmPassword() {
        return EspecialidadtextField;
    }

}