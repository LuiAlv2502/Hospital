package org.example.Module.wrappers;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v); // parsea de String (ej: "2025-01-01")
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString(); // lo guarda como ISO-8601 (aaaa-mm-dd)
    }
}
