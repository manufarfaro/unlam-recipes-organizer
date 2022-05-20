package ar.edu.unlam.Model;

import java.util.ArrayList;

public class Receta {
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    public Receta(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean addIngrediente(Ingrediente ingrediente) {
        return this.ingredientes.add(ingrediente);
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public String getReadableData() {
        StringBuilder str = new StringBuilder();
        str.append(this.getNombre() + " [");
        this.ingredientes.forEach(ingrediente -> str.append(" - " + ingrediente.getNombre() + " " + ingrediente.getCantidad()));
        str.append(" ]");
        return str.toString();
    }
}
