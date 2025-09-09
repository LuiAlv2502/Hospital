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

    public Receta() {
        // Constructor vacío para JAXB
    }

    public Receta(String idReceta, Medico medico, Paciente paciente) {
        this.idReceta = idReceta;
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

    // ===== Getters y Setters =====

    public String getIdReceta() { return idReceta; }
    public void setIdReceta(String idReceta) { this.idReceta = idReceta; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDate getFechaConfeccion() { return fechaConfeccion; }
    public void setFechaConfeccion(LocalDate fechaConfeccion) { this.fechaConfeccion = fechaConfeccion; }

    public LocalDate getFechaRetiro() { return fechaRetiro; }
    public void setFechaRetiro(LocalDate fechaRetiro) { this.fechaRetiro = fechaRetiro; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<DetalleMedicamento> getMedicamentos() { return medicamentos; }
    public void setMedicamentos(List<DetalleMedicamento> medicamentos) { this.medicamentos = medicamentos; }
}