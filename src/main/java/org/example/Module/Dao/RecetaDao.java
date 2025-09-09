package org.example.Module.Dao;

import jakarta.xml.bind.*;
import org.example.Module.Receta;
import org.example.Module.wrappers.RecetasWrapper;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecetaDao {

    private static final String FILE_PATH = "src/main/resources/recetas.xml";

    private RecetasWrapper wrapper;

    public RecetaDao() {
        cargar();
    }

    private void cargar() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                wrapper = new RecetasWrapper();
                guardar();
                return;
            }
            JAXBContext context = JAXBContext.newInstance(RecetasWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            wrapper = (RecetasWrapper) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
            wrapper = new RecetasWrapper();
        }
    }

    private void guardar() {
        try {
            JAXBContext context = JAXBContext.newInstance(RecetasWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // === CRUD de solo lectura ===
    public List<Receta> getAll() {
        return wrapper.getRecetas();
    }

    public Optional<Receta> buscarPorId(String id) {
        return wrapper.getRecetas().stream()
                .filter(r -> r.getIdReceta().equalsIgnoreCase(id))
                .findFirst();
    }

    public List<Receta> buscarPorEstado(String estado) {
        return wrapper.getRecetas().stream()
                .filter(r -> r.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public List<Receta> buscarPorPaciente(String pacienteId) {
        return wrapper.getRecetas().stream()
                .filter(r -> r.getPaciente() != null && r.getPaciente().getId().equals(pacienteId))
                .collect(Collectors.toList());
    }
}