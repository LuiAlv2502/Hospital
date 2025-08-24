package org.example.Module;

import org.example.Module.Medicamento;


public class DetalleMedicamento {
    private Medicamento medicamento;
    private int cantidad;
    private String indicaciones;
    private int duracionDias;

    public DetalleMedicamento(Medicamento medicamento, int cantidad, String indicaciones, int duracionDias) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.indicaciones = indicaciones;
        this.duracionDias = duracionDias;
    }
}