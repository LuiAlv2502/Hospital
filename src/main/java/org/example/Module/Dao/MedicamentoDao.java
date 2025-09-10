package org.example.Module.Dao;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Module.Medicamento;
import org.example.Module.wrappers.MedicamentosWrapper;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MedicamentoDao {

    private static final String FILE_PATH = "src/main/resources/medicamentos.xml";

    public MedicamentosWrapper loadMedicamentos() {
        try {
            JAXBContext context = JAXBContext.newInstance(MedicamentosWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return (MedicamentosWrapper) unmarshaller.unmarshal(file);
            } else {
                return new MedicamentosWrapper();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MedicamentosWrapper();
        }
    }

    public void saveMedicamentos(MedicamentosWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(MedicamentosWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMedicamento(Medicamento medicamento) {
        MedicamentosWrapper wrapper = loadMedicamentos();
        List<Medicamento> list = wrapper.getMedicamentos();

        boolean exists = list.stream().anyMatch(m -> m.getCodigo().equals(medicamento.getCodigo()));
        if (!exists) {
            list.add(medicamento);
            saveMedicamentos(wrapper);
            System.out.println("Medicamento guardado: " + medicamento.getCodigo());
        } else {
            System.out.println("Medicamento con código " + medicamento.getCodigo() + " ya existe.");
        }
    }

    public boolean removeMedicamentoByCodigo(String codigo) {
        MedicamentosWrapper wrapper = loadMedicamentos();
        boolean removed = wrapper.getMedicamentos().removeIf(m -> m.getCodigo().equals(codigo));
        if (removed) saveMedicamentos(wrapper);
        return removed;
    }

    public Optional<Medicamento> findByCodigo(String codigo) {
        return loadMedicamentos().getMedicamentos().stream()
                .filter(m -> m.getCodigo().equals(codigo))
                .findFirst();
    }

    // Búsqueda aproximada por código o nombre
    public List<Medicamento> search(String query) {
        String q = query.toLowerCase();
        return loadMedicamentos().getMedicamentos().stream()
                .filter(m -> m.getCodigo().toLowerCase().contains(q) ||
                        m.getNombre().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
    public Medicamento searchMedicamentoByCodigo(String codigo) {
        return loadMedicamentos().getMedicamentos().stream()
                .filter(m -> m.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}