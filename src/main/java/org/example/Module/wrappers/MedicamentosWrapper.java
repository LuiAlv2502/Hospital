package org.example.Module.wrappers;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.Module.Medicamento;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "medicamentos")
public class MedicamentosWrapper {
    private List<Medicamento> medicamentos = new ArrayList<>();

    @XmlElement(name = "medicamento")
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}