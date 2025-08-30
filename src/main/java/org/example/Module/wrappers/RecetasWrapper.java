package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.*;
import org.example.Module.Receta;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "recetasWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecetasWrapper {

    @XmlElement(name = "receta")
    private List<Receta> recetas = new ArrayList<>();

    public RecetasWrapper() {
        this.recetas = new ArrayList<>();
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
}