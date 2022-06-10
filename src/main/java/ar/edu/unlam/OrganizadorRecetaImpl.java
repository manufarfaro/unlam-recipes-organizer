package ar.edu.unlam;

import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;
import ar.edu.unlam.Services.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrganizadorRecetaImpl implements OrganizadorReceta {
    ServicioRecetasFactory servicioRecetasFactory;
    ArrayList<Receta> recetas;
    ArrayList<Ingrediente> ingredientesDisponibles;

    public OrganizadorRecetaImpl(ServiciosRecetasType serviciosRecetasType, String recetasPath, String ingredientesPath) throws InvalidServiciosRecetasException {
        this.servicioRecetasFactory = new ServicioRecetasFactoryImpl();
        ServicioRecetas servicioRecetas = this.servicioRecetasFactory.createServiciosRecetas(serviciosRecetasType, recetasPath, ingredientesPath);
        this.recetas = servicioRecetas.getRecetas();
        this.ingredientesDisponibles = servicioRecetas.getIngredientes();
    }

    @Override
    public ArrayList<Receta> getRecetasValidas() {
        return recetas
                .stream()
                .filter(receta -> this.hayIngredientesSuficientes(receta.getIngredientes(), this.ingredientesDisponibles))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean hayIngredientesSuficientes(ArrayList<Ingrediente> recetaIngredientes, ArrayList<Ingrediente> ingredientesDisponibles) {
        if (recetaIngredientes.size() < 1) {
            return true;
        }
        int matchedQtyIngredientes = 0;
        for (Ingrediente recetaIngrediente : recetaIngredientes) {
            for (Ingrediente ingredienteDisponible : ingredientesDisponibles) {
                if (
                    recetaIngrediente.getNombre().equals(ingredienteDisponible.getNombre()) &&
                    recetaIngrediente.getCantidadAsScalar() <= ingredienteDisponible.getCantidadAsScalar()
                ) {
                    matchedQtyIngredientes++;
                }
            }
        }
        return matchedQtyIngredientes == recetaIngredientes.size();
    }
}
