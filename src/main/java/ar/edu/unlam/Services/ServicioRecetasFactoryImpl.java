package ar.edu.unlam.Services;

public class ServicioRecetasFactoryImpl implements ServicioRecetasFactory {
    public ServicioRecetas createServiciosRecetas(ServiciosRecetasType serviciosRecetasType, String recetasPath, String ingredientesPath) throws InvalidServiciosRecetasException {
        return switch (serviciosRecetasType) {
            case TXT -> new ServicioRecetasTXT(recetasPath, ingredientesPath);
            case DB -> new ServicioRecetasDB();
            default -> throw new InvalidServiciosRecetasException("Tipo de servicio invalido o no seleccionado");
        };
    }
}
