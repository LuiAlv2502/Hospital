package org.example.Control;

import org.example.Module.Dao.RecetaDao;
import org.example.View.RecetaView;
import org.example.View.prescribir;
import org.example.Module.Servicio.PrescripcionService;
import org.example.Control.PrescripcionController;

public class panelMedicoController {
     prescribir prescribir;
    PrescripcionService prescribirService;
    PrescripcionController prescripcionController;
    RecetaDao recetaDao;
    RecetaView recetaView;
    RecetaController recetaController;

    public panelMedicoController(prescribir prescribir, PrescripcionService prescribirService, RecetaDao recetaDao, RecetaView recetaView) {
        this.prescribir = prescribir;
        this.prescribirService = prescribirService;
        this.recetaDao = recetaDao;
        this.recetaView = recetaView;
        initController();
    }
    private void initController() {
        this.prescripcionController = new PrescripcionController(prescribir, prescribirService);
        this.recetaController = new RecetaController(recetaView, recetaDao);
    }
}
