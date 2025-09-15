package org.example.Control;

import org.example.View.FarmaceutaPanel;
import org.example.View.DespachoView;
import org.example.Module.Servicio.DespachoService;
import org.example.Module.Dao.RecetaDao;

public class PanelFarmaceutaController {
    private FarmaceutaPanel farmaceutaPanel;
    private DespachoService despachoService;
    private RecetaDao recetaDao;
    private DespachoController despachoController;

    public PanelFarmaceutaController(FarmaceutaPanel farmaceutaPanel, DespachoService despachoService, RecetaDao recetaDao) {
        this.farmaceutaPanel = farmaceutaPanel;
        this.despachoService = despachoService;
        this.recetaDao = recetaDao;
        initController();
    }

    private void initController() {
        this.despachoController = new DespachoController(farmaceutaPanel.getDespachoPanel(), despachoService, recetaDao);
    }
}
