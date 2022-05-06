package ar.edu.unlam.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Receta {
    private String nombre;
    private Map<String, String> ingredientes;
    public Receta(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new HashMap<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String addIngrediente(String nombre, String cantidad) {
        return this.ingredientes.put(nombre, cantidad);
    }

    public Map<String, String> getIngredientes() {
        return this.ingredientes;
    }

    public String getReadableData() {
        StringBuilder str = new StringBuilder();
        str.append(this.getNombre() + " [");
        this.ingredientes.forEach((k, v) -> str.append(" - " + v + " " + k));
        str.append(" ]");
        return str.toString();
    }
}
