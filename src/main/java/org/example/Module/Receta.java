package org.example.Module;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "receta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Receta {

    private String idReceta;

    @XmlElement
    private Medico medico;

    @XmlElement
    private Paciente paciente;

    @XmlElement
    private LocalDate fechaConfeccion;

    @XmlElement
    private LocalDate fechaRetiro;

    @XmlElement
    private String estado; // "en_proceso", "confeccionada", "entregada", etc.

    @XmlElement(name = "detalleMedicamento")
    private List<DetalleMedicamento> medicamentos = new ArrayList<>();

    // Constructor vacío requerido por JAXB
    public Receta() {
    }

    public Receta(Medico medico, Paciente paciente) {
        this.medico = medico;
        this.paciente = paciente;
        this.fechaConfeccion = LocalDate.now();
        this.estado = "en_proceso";
    }

    // Getters y setters

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

    // Métodos de negocio

    public void agregarMedicamento(DetalleMedicamento detalle) {
        medicamentos.add(detalle);
    }

    public void eliminarMedicamento(DetalleMedicamento detalle) {
        medicamentos.remove(detalle);
    }

    public void registrar(LocalDate fechaRetiro) {
        this.estado = "confeccionada";
        this.fechaRetiro = fechaRetiro;
    }
}