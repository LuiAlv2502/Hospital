package org.example.Module.Dao;

import jakarta.xml.bind.*;
import org.example.Module.Medicamento;
import org.example.Module.wrappers.MedicamentosWrapper;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MedicamentosDao {

    private final String filePath = "medicamentos.xml";
    private MedicamentosWrapper wrapper;

    public MedicamentosDao() {
        cargar();
    }

    // === Cargar datos desde XML ===
    private void cargar() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                wrapper = new MedicamentosWrapper();
                guardar();
                return;
            }
            JAXBContext context = JAXBContext.newInstance(MedicamentosWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            wrapper = (MedicamentosWrapper) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
            wrapper = new MedicamentosWrapper();
        }
    }

    // === Guardar datos en XML ===
    private void guardar() {
        try {
            JAXBContext context = JAXBContext.newInstance(MedicamentosWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // === CRUD ===

    public List<Medicamento> getAll() {
        return wrapper.getMedicamentos();
    }

    public Optional<Medicamento> buscarPorCodigo(String codigo) {
        return wrapper.getMedicamentos().stream()
                .filter(m -> m.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public List<Medicamento> buscarPorNombre(String nombre) {
        return wrapper.getMedicamentos().stream()
                .filter(m -> m.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void add(Medicamento medicamento) {
        wrapper.getMedicamentos().add(medicamento);
        guardar();
    }

    public void update(Medicamento medicamento) {
        buscarPorCodigo(medicamento.getCodigo()).ifPresent(m -> {
            m.setNombre(medicamento.getNombre());
            m.setPresentacion(medicamento.getPresentacion());
            guardar();
        });
    }

    public boolean eliminarPorCodigo(String codigo) {
        boolean removed = wrapper.getMedicamentos()
                .removeIf(m -> m.getCodigo().equalsIgnoreCase(codigo));
        if (removed) {
            guardar();
        }
        return removed;
    }
}