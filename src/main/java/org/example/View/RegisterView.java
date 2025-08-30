package org.example.View;

import javax.swing.*;

public class RegisterView extends JFrame{
    private JPanel panel;
    private JLabel apellidos;
    private JLabel nombre;
    private JLabel especialidad;
    private JTextField campoNombre;
    private JButton ingresarButton;
    private JPasswordField campoContra;
    private JTextField campoId;
    private JTextField campoEspecialidad;
    private JPasswordField campoConfirmaContra;
    private JButton registrarseButton;
    private JLabel registroLink;
    private JComboBox comboBoxRol;
    private JTextField campoFecha;
    private JLabel recuperaPassword;
    private JLabel contraRegistro;
    private JLabel loginHyperlink;
    private JLabel fecha;
    private JLabel confirma;

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
        return campoNombre;
    }
    public JTextField getIdtextField() {
        return campoId;
    }
    public JTextField getEspecialidadtextField() {
        return campoEspecialidad;
    }
    public JButton getIngresarButton() {
        return ingresarButton;
    }
    public JPasswordField getPasswordField1() {
        return campoContra;
    }
    public JPasswordField getPasswordField2() {
        return campoConfirmaContra;
    }
    public String getComboBoxRol() {
        return comboBoxRol.getSelectedItem().toString();
    }
    public JTextField getFecha() {
        return campoFecha;
    }


    public JTextField getTxtConfirmPassword() {
        return campoEspecialidad;
    }

}