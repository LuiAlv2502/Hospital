package org.example.View;

import javax.swing.*;

public class AdminPanel extends JFrame {
    MedicoView medicoView;
    FarmaceuticoView farmaceuticoView;
    public AdminPanel() {
        setTitle("Administración Hospitalaria");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregamos las pestañas
        medicoView = new MedicoView();
        farmaceuticoView = new FarmaceuticoView();


        tabbedPane.addTab("Farmacéuticos", farmaceuticoView);
        tabbedPane.addTab("Médicos", medicoView);

        add(tabbedPane);
        setVisible(true);
    }

    public FarmaceuticoView getFarmaceuticoPanel() {
        return this.farmaceuticoView;
    }

    public MedicoView getMedicoPanel() {
        return this.medicoView;
    }
}