package org.example.Module;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medicamento")
public class Medicamento {
    private String codigo;
    private String nombre;
    private String presentacion;

    @XmlElement public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @XmlElement public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @XmlElement public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }
}