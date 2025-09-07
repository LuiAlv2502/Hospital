package org.example.View;

import javax.swing.*;

public class AdminPanel extends JFrame {

    public AdminPanel() {
        setTitle("Administración Hospitalaria");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregamos las pestañas
        MedicoPanel medicoPanel = new MedicoPanel();
        FarmaceuticoPanel farmaceuticoPanel = new FarmaceuticoPanel();


        tabbedPane.addTab("Farmacéuticos", new FarmaceuticoPanel());
        tabbedPane.addTab("Médicos", medicoPanel);

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPanel();
    }
}