package ar.edu.unlam.Services;

import ar.edu.unlam.Model.Receta;
import ar.edu.unlam.Util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ServicioRecetas {
    public static ArrayList<Receta> getRecetasFromFolder(String folderPath) {

        List<List<String>> folder = FileUtil.readFolder(folderPath);

        ArrayList<Receta> recetas = new ArrayList<>();

        for( List<String> recetaItem : folder) {
            Receta receta = new Receta(recetaItem.get(0));

            for (int i = 1; i < recetaItem.size(); i++) {
                String[] splitLine = recetaItem.get(i).split(" ");
                String ingredienteNombre = String.join(" ", Arrays.copyOfRange(splitLine, 1, splitLine.length));
                receta.addIngrediente(ingredienteNombre, splitLine[0]);
            }
            recetas.add(receta);
        }

        return recetas;
    }


    public static HashMap<String, String> getIngredientesFromFile(String filepath) {
        List<String> lines = FileUtil.readFileInList(filepath);
        HashMap<String, String> ingredientes = new HashMap<String, String>();

        for (String line : lines) {
            String[] splitLine = line.split(" ");
            String ingredienteNombre = String.join(" ", Arrays.copyOfRange(splitLine, 1, splitLine.length));
            ingredientes.put(ingredienteNombre, splitLine[0]);
        }

        return ingredientes;
    }
}
