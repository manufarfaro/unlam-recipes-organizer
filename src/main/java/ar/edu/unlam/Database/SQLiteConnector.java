package ar.edu.unlam.Database;

import java.sql.DriverManager;

public class SQLiteConnector {
    public static java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:recetas.sqlite");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
