package org.example.Control;

import org.example.View.prescribir;
import org.example.Module.Service.PrescripcionService;
import org.example.Control.PrescripcionController;

public class panelMedicoController {
    prescribir prescribir;
    PrescripcionService prescribirService;
    PrescripcionController prescripcionController;
    public panelMedicoController(prescribir prescribir, PrescripcionService prescribirService) {
        this.prescribir = prescribir;
        this.prescribirService = prescribirService;
        initController();
    }
    private void initController() {
        this.prescripcionController = new PrescripcionController(prescribir, prescribirService);

    }
}
