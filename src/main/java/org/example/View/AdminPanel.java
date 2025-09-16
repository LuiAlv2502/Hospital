package org.example.View;

import javax.swing.*;

public class AdminPanel extends JFrame {
    MedicoView medicoView;
    FarmaceuticoView farmaceuticoView;
    PacienteView pacienteView;
    RecetaView recetaView;
    MedicamentoView medicamentoView;

    public AdminPanel() {
        setTitle("Administración Hospitalaria");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        medicoView = new MedicoView();
        farmaceuticoView = new FarmaceuticoView();
        pacienteView = new PacienteView();
        recetaView = new RecetaView();
        medicamentoView = new MedicamentoView();
        dashboard dashboardView = new dashboard();
        new org.example.Control.DashboardController(dashboardView);

        tabbedPane.addTab("Farmacéuticos", farmaceuticoView);
        tabbedPane.addTab("Médicos", medicoView);
        tabbedPane.addTab("Pacientes",pacienteView);
        tabbedPane.addTab("Historial de Recetas",recetaView);
        tabbedPane.addTab("Medicamentos",medicamentoView);
        tabbedPane.addTab("Indicadores", dashboardView);

        add(tabbedPane);
        setVisible(true);
    }

    public FarmaceuticoView getFarmaceuticoPanel() {
        return this.farmaceuticoView;
    }

    public MedicoView getMedicoPanel() {
        return this.medicoView;
    }

    public PacienteView getPacientePanel() {
        return this.pacienteView;
    }

    public RecetaView getRecetaView() {
    return this.recetaView;
    }

    public MedicamentoView getMedicamentoView() {
        return this.medicamentoView;
    }


}