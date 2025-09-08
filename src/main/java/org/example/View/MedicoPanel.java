package org.example.View;

import javax.swing.*;

public class MedicoPanel extends JFrame{
    prescribir prescribir;
    public MedicoPanel() {
        setTitle("Administración Hospitalaria");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregamos las pestañas
        this.prescribir = new prescribir();
        tabbedPane.addTab("Médicos", prescribir);

        add(tabbedPane);
        setVisible(true);
    }
    public prescribir getPrescribir() {
        return this.prescribir;
    }
}
