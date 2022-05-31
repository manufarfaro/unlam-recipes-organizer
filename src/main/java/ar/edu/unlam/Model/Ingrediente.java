package ar.edu.unlam.Model;

import ar.edu.unlam.Util.UnitsUtil;

public class Ingrediente {
    String nombre;
    String cantidad;

    public Ingrediente(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public float getCantidadAsScalar() {
        return UnitsUtil.convertRecipesUnitToFloat(this.cantidad);
    }
}
