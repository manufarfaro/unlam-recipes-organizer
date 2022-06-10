package ar.edu.unlam.Services;

import ar.edu.unlam.Database.*;
import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;

import java.util.ArrayList;

public class ServicioRecetasDB extends ServicioRecetas {
    RecetasDao recetasDao;
    IngredientesDao ingredientesDao;

    public ServicioRecetasDB() {
        this.recetasDao = new RecetasDaoImpl();
        this.ingredientesDao = new IngredientesDaoImpl();
    }

    @Override
    public ArrayList<Receta> getRecetas() {
        return this.recetasDao.getAll();
    }

    @Override
    public ArrayList<Ingrediente> getIngredientes() {
        return this.ingredientesDao.getAll();
    }

}
