package org.example.Control;

import org.example.View.FarmaceutaPanel;
import org.example.View.DespachoView;
import org.example.Module.Servicio.DespachoService;
import org.example.Module.Dao.RecetaDao;
import org.example.View.RecetaView;

public class PanelFarmaceutaController {
    private FarmaceutaPanel farmaceutaPanel;
    private DespachoService despachoService;
    private RecetaDao recetaDao;
    private RecetaView recetaView;
    private DespachoController despachoController;
    private RecetaController recetaController;

    public PanelFarmaceutaController(FarmaceutaPanel farmaceutaPanel, DespachoService despachoService, RecetaDao recetaDao, RecetaView recetaView) {
        this.farmaceutaPanel = farmaceutaPanel;
        this.despachoService = despachoService;

        this.recetaDao = recetaDao;
        this.recetaView = recetaView;
        initController();
    }

    private void initController() {
        this.despachoController = new DespachoController(farmaceutaPanel.getDespachoPanel(), despachoService, recetaDao);
        this.recetaController = new RecetaController(recetaView, recetaDao);
    }
}
