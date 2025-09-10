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

    private MedicamentosWrapper loadMedicamentos() {
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

    private void saveMedicamentos(MedicamentosWrapper wrapper) {
        try {
            JAXBContext context = JAXBContext.newInstance(MedicamentosWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // === Métodos que el Controller espera ===

    public List<Medicamento> getAll() {
        return loadMedicamentos().getMedicamentos();
    }

    public void add(Medicamento medicamento) {
        MedicamentosWrapper wrapper = loadMedicamentos();
        List<Medicamento> list = wrapper.getMedicamentos();

        boolean exists = list.stream().anyMatch(m -> m.getCodigo().equalsIgnoreCase(medicamento.getCodigo()));
        if (!exists) {
            list.add(medicamento);
            saveMedicamentos(wrapper);
            System.out.println("Medicamento guardado: " + medicamento.getCodigo());
        } else {
            System.out.println("Medicamento con código " + medicamento.getCodigo() + " ya existe.");
        }
    }

    public boolean eliminarPorCodigo(String codigo) {
        MedicamentosWrapper wrapper = loadMedicamentos();
        boolean removed = wrapper.getMedicamentos().removeIf(m -> m.getCodigo().equalsIgnoreCase(codigo));
        if (removed) {
            saveMedicamentos(wrapper);
        }
        return removed;
    }

    public Optional<Medicamento> buscarPorCodigo(String codigo) {
        return loadMedicamentos().getMedicamentos().stream()
                .filter(m -> m.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public List<Medicamento> buscarPorNombre(String nombre) {
        String q = nombre.toLowerCase();
        return loadMedicamentos().getMedicamentos().stream()
                .filter(m -> m.getNombre().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}