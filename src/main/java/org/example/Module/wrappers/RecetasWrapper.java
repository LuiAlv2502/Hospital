package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.Module.Receta;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "recetas")
public class RecetasWrapper {

    private List<Receta> recetas = new ArrayList<>();

    @XmlElement(name = "receta")
    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
}