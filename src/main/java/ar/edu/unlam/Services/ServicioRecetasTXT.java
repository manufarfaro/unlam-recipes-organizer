package ar.edu.unlam.Services;

import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;
import ar.edu.unlam.Util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServicioRecetasTXT extends ServicioRecetas {
    String recetasPath;
    String ingredientesPath;
    public ServicioRecetasTXT(String recetasPath, String ingredientesPath) {
        this.recetasPath = recetasPath;
        this.ingredientesPath = ingredientesPath;
    }

    @Override
    public ArrayList<Receta> getRecetas() {

        List<List<String>> folder = FileUtil.readFolder(this.recetasPath);

        ArrayList<Receta> recetas = new ArrayList<>();

        for( List<String> recetaItem : folder) {
            Receta receta = new Receta(recetaItem.get(0));

            for (int i = 1; i < recetaItem.size(); i++) {
                String[] splitLine = recetaItem.get(i).split(" ");
                String ingredienteNombre = String.join(" ", Arrays.copyOfRange(splitLine, 1, splitLine.length));
                Ingrediente ingrediente = new Ingrediente(ingredienteNombre, splitLine[0]);
                receta.addIngrediente(ingrediente);
            }
            recetas.add(receta);
        }

        return recetas;
    }


    @Override
    public ArrayList<Ingrediente> getIngredientes() {
        List<String> lines = FileUtil.readFileInList(this.ingredientesPath);
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        for (String line : lines) {
            String[] splitLine = line.split(" ");
            String ingredienteNombre = String.join(" ", Arrays.copyOfRange(splitLine, 1, splitLine.length));
            Ingrediente ingrediente = new Ingrediente(ingredienteNombre, splitLine[0]);
            ingredientes.add(ingrediente);
        }

        return ingredientes;
    }
}
