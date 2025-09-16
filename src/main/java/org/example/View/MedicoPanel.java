package org.example.View;

import javax.swing.*;

public class MedicoPanel extends JFrame{
    prescribir prescribir;
    RecetaView recetaView;
    public MedicoPanel() {
        setTitle("Administración Hospitalaria");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        this.prescribir = new prescribir();
        this.recetaView = new RecetaView();

        tabbedPane.addTab("Médicos", prescribir);
        tabbedPane.addTab("Historial de Recetas", recetaView);

        add(tabbedPane);
        setVisible(true);
    }
    public prescribir getPrescribir() {
        return this.prescribir;
    }

    public RecetaView getRecetaView() {
        return this.recetaView;
    }
}
