package org.example.Module;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "detalleMedicamento")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetalleMedicamento {

    @XmlElement
    private String codigoMedicamento;

    @XmlElement
    private int cantidad;

    @XmlElement
    private String indicaciones;

    @XmlElement
    private int duracionDias;

    // Este campo NO lo anotamos con @XmlElement porque probablemente no quieras serializar todo el Medicamento
    private Medicamento medicamento;

    // Constructor vacío requerido por JAXB
    public DetalleMedicamento() {
    }

    public DetalleMedicamento(String codigoMedicamento, int cantidad, String indicaciones, int duracionDias) {
        this.codigoMedicamento = codigoMedicamento;
        this.cantidad = cantidad;
        this.indicaciones = indicaciones;
        this.duracionDias = duracionDias;
    }

    // Getters y setters
    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(String codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    // Método de conveniencia para obtener nombre del medicamento
    public String getNombre() {
        return medicamento != null ? medicamento.getNombre() : null;
    }
}