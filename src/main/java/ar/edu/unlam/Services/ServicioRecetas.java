package ar.edu.unlam.Services;

import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;

import java.util.ArrayList;

public abstract class ServicioRecetas {
    public ArrayList<Receta> getRecetas(){
        return new ArrayList<>();
    };

    public ArrayList<Ingrediente> getIngredientes(){
        return new ArrayList<>();
    };
}
