package ar.edu.unlam.Services;

public interface ServicioRecetasFactory {
    public ServicioRecetas createServiciosRecetas(ServiciosRecetasType serviciosRecetasType, String recetasPath, String ingredientesPath) throws InvalidServiciosRecetasException;
}
