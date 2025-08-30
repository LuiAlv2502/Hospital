package org.example.Module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Receta {
    private String idReceta;
    private Medico medico;
    private Paciente paciente;
    private LocalDate fechaConfeccion;
    private LocalDate fechaRetiro;
    private String estado; // confeccionada, entregada, etc.

    private List<DetalleMedicamento> medicamentos = new ArrayList<>();

    public Receta(Medico medico, Paciente paciente) {
        this.medico = medico;
        this.paciente = paciente;
        this.fechaConfeccion = LocalDate.now();
        this.estado = "en_proceso";
    }

    public void agregarMedicamento(DetalleMedicamento detalle) {
        medicamentos.add(detalle);
    }

    public void eliminarMedicamento(DetalleMedicamento detalle) {
        medicamentos.remove(detalle);
    }

    public void registrar() {
        this.estado = "confeccionada";
        this.fechaRetiro = LocalDate.now(); // o lógica para sumarle días
    }
}