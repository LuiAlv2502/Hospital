package org.example.Control;

import org.example.Module.Dao.FarmaceuticoDao;
import org.example.Module.Dao.MedicoDao;
import org.example.Module.Dao.PacienteDao;
import org.example.Module.Dao.RecetaDao;
import org.example.Module.Dao.MedicamentoDao;

import org.example.View.FarmaceuticoView;
import org.example.View.MedicoView;
import org.example.View.PacienteView;
import org.example.View.RecetaView;
import org.example.View.MedicamentoView;

public class PanelAdminController {
    MedicoDao medicoDao;
    FarmaceuticoDao farmaceuticoDao;
    PacienteDao pacienteDao;
    RecetaDao recetaDao;
    MedicamentoDao medicamentoDao;


    FarmaceuticoView farmaceuticoView;
    MedicoView medicoView;
    PacienteView pacienteView;
    RecetaView recetaView;
    MedicamentoView medicamentoView;

    MedicoController medicoController;
    FarmaceuticoController farmaceuticoController;
    PacienteController pacienteController;
    RecetaController recetaController;
    MedicamentosController medicamentoController;


    public PanelAdminController(MedicoDao medicoDao,
                                FarmaceuticoDao farmaceuticoDao,
                                FarmaceuticoView farmaceuticoView,
                                MedicoView medicoPanel,
                                PacienteView pacienteView,
                                PacienteDao pacienteDao,
                                RecetaDao recetaDao,
                                RecetaView recetaView,
                                MedicamentoDao medicamentoDao,
                                MedicamentoView medicamentoView) {
        this.farmaceuticoView = farmaceuticoView;
        this.medicoView = medicoPanel;
        this.pacienteView = pacienteView;
        this.recetaView = recetaView;
        this.medicamentoView = medicamentoView;

        this.medicoDao = medicoDao;
        this.farmaceuticoDao = farmaceuticoDao;
        this.pacienteDao = pacienteDao;
        this.recetaDao = recetaDao;
        this.medicamentoDao = medicamentoDao;
        initController();
    }
    private void initController() {
        this.medicoController = new MedicoController(medicoView, medicoDao);
        this.farmaceuticoController = new FarmaceuticoController(farmaceuticoView, farmaceuticoDao);
        this.pacienteController = new PacienteController(pacienteView, pacienteDao);
        this.recetaController = new RecetaController(recetaView, recetaDao);
        this.medicamentoController = new MedicamentosController(medicamentoView, medicamentoDao);
    }
}
