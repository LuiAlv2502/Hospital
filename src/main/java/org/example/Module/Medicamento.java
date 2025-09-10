package org.example.Module;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medicamento")
public class Medicamento {
    private String codigo;
    private String nombre;
    private String presentacion;

    // Constructor vacío requerido por JAXB
    public Medicamento() {
    }

    public Medicamento(String codigo, String nombre, String presentacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presentacion = presentacion;
    }

    @XmlElement
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @XmlElement
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @XmlElement
    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }

    // equals y hashCode basados en codigo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicamento)) return false;
        Medicamento that = (Medicamento) o;
        return codigo != null && codigo.equalsIgnoreCase(that.codigo);
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return nombre + " (" + presentacion + ")";
    }
}