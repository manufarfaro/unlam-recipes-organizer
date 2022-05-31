package ar.edu.unlam;

import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;
import ar.edu.unlam.Services.ServicioRecetas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrganizadorRecetaImpl implements OrganizadorReceta {
    ArrayList<Receta> recetas;
    ArrayList<Ingrediente> ingredientesDisponibles;

    public OrganizadorRecetaImpl(String recetasPath, String ingredientesPath) {
        this.recetas = ServicioRecetas.getRecetasFromFolder(recetasPath);
        this.ingredientesDisponibles = ServicioRecetas.getIngredientesFromFile(ingredientesPath);
    }

    @Override
    public ArrayList<Receta> getRecetasValidas() {
        return recetas
                .stream()
                .filter(receta -> this.hayIngredientesSuficientes(receta.getIngredientes(), this.ingredientesDisponibles))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean hayIngredientesSuficientes(ArrayList<Ingrediente> recetaIngredientes, ArrayList<Ingrediente> ingredientesDisponibles) {
        for (Ingrediente recetaIngrediente : recetaIngredientes) {
            for (Ingrediente ingredienteDisponible : ingredientesDisponibles) {
                if (
                    recetaIngrediente.getNombre().equals(ingredienteDisponible.getNombre()) &&
                    recetaIngrediente.getCantidadAsScalar() <= ingredienteDisponible.getCantidadAsScalar()
                ) {
                    return true;
                }
            }
        }
        return false;
    }
}
