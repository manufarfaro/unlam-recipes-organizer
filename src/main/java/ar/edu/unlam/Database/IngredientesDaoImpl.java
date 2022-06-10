package ar.edu.unlam.Database;

import ar.edu.unlam.Model.Ingrediente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientesDaoImpl implements IngredientesDao{
    java.sql.Connection connection;
    String getAllIngredientesQuery = "SELECT ingredientes.name AS name, quantity FROM ingredientes_disponibles INNER JOIN ingredientes on ingredientes.id = ingredientes_disponibles.ingrediente_id;";

    public IngredientesDaoImpl() {
        this.connection = SQLiteConnector.getConnection();
    }

    @Override
    public ArrayList<Ingrediente> getAll() {
        try {
            ArrayList<Ingrediente> ingredientes = new ArrayList<>();

            try (PreparedStatement preparedStatement = this.connection.prepareStatement(this.getAllIngredientesQuery)) {

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        ingredientes.add(new Ingrediente(
                            resultSet.getString("name"),
                            resultSet.getString("quantity")
                        ));
                    }
                }
            }

            return ingredientes;
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
