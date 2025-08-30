package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.*;
import org.example.Module.Farmaceutico;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "farmaceuticosWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class FarmaceuticosWrapper {

    @XmlElement(name = "farmaceutico")
    private List<Farmaceutico> farmaceuticos = new ArrayList<>();

    public FarmaceuticosWrapper() {
        this.farmaceuticos = new ArrayList<>();
    }

    public List<Farmaceutico> getFarmaceuticos() {
        return farmaceuticos;
    }

    public void setFarmaceuticos(List<Farmaceutico> farmaceuticos) {
        this.farmaceuticos = farmaceuticos;
    }
}