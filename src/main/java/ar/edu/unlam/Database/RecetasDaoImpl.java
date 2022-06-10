package ar.edu.unlam.Database;

import ar.edu.unlam.Model.Ingrediente;
import ar.edu.unlam.Model.Receta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecetasDaoImpl implements RecetasDao{
    java.sql.Connection connection;
    private String getAllRecetasQuery = "SELECT id, name FROM recetas";
    private String getIngredientesByRecetaQuery = "SELECT ingredientes.name AS name, quantity FROM recetas_ingredientes INNER JOIN ingredientes on ingredientes.id = recetas_ingredientes.ingrediente_id WHERE receta_id = ?;";

    public RecetasDaoImpl() {
        this.connection = SQLiteConnector.getConnection();
    }

    public ArrayList<Receta> getAll() {
        try {
            ArrayList<Receta> recetas = new ArrayList<>();

            try (PreparedStatement recetaPs = this.connection.prepareStatement(this.getAllRecetasQuery)) {

                try (ResultSet recetaResultSet = recetaPs.executeQuery()) {
                    while (recetaResultSet.next()) {
                        Receta receta = new Receta(recetaResultSet.getString("name"));

                        try (PreparedStatement ingredientePs = this.connection.prepareStatement(this.getIngredientesByRecetaQuery)) {
                            ingredientePs.setInt(1, recetaResultSet.getInt("id"));
                            try (ResultSet ingredienteResultSet = ingredientePs.executeQuery()) {
                                while(ingredienteResultSet.next()) {
                                    receta.addIngrediente(new Ingrediente(
                                            ingredienteResultSet.getString("name"),
                                            ingredienteResultSet.getString("quantity")
                                    ));
                                }
                            }
                        }
                        recetas.add(receta);
                    }
                }
            }
            return recetas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
