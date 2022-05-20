package ar.edu.unlam;

import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;
import ar.edu.unlam.Services.ServicioRecetas;

import java.util.ArrayList;
import java.util.HashMap;

public class OrganizadorRecetaImpl implements OrganizadorReceta {
    ArrayList<Receta> recetas;
    ArrayList<Ingrediente> ingredientes;

    public OrganizadorRecetaImpl(String recetasPath, String ingredientesPath) {
        this.recetas = ServicioRecetas.getRecetasFromFolder(recetasPath);
        this.ingredientes = ServicioRecetas.getIngredientesFromFile(ingredientesPath);
    }

    @Override
    public ArrayList<Receta> getRecetasValidas() {
        return recetas;
    }

    private boolean hayIngredientesSuficientes(ArrayList<Ingrediente> recetaIngredientes, ArrayList<Ingrediente> ingredientesDisponible) {
        return true;
    }
}
