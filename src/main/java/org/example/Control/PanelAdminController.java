package org.example.Control;

import org.example.Module.Dao.FarmaceuticoDao;
import org.example.Module.Dao.MedicoDao;
import org.example.View.FarmaceuticoView;
import org.example.View.MedicoView;

public class PanelAdminController {
    MedicoDao medicoDao;
    FarmaceuticoDao farmaceuticoDao;
    FarmaceuticoView farmaceuticoView;
    MedicoView medicoView;
    MedicoController medicoController;
    FarmaceuticoController farmaceuticoController;

    public PanelAdminController(MedicoDao medicoDao, FarmaceuticoDao farmaceuticoDao, FarmaceuticoView farmaceuticoView, MedicoView medicoPanel) {
        this.farmaceuticoView = farmaceuticoView;
        this.medicoView = medicoPanel;
        this.medicoDao = medicoDao;
        this.farmaceuticoDao = farmaceuticoDao;
        initController();
    }
    private void initController() {
        this.medicoController = new MedicoController(medicoView, medicoDao);
        this.farmaceuticoController = new FarmaceuticoController(farmaceuticoView, farmaceuticoDao);
    }


}
