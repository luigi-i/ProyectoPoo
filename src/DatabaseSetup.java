import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createNewDatabase() {
        String url = "jdbc:sqlite:vehiculos.db";

        String sqlVehiculos = "CREATE TABLE IF NOT EXISTS vehiculos (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " modelo TEXT NOT NULL,\n"
                + " marca TEXT NOT NULL,\n"
                + " anio INTEGER NOT NULL,\n"
                + " kilometraje REAL NOT NULL\n"
                + ");";

        String sqlServicios = "CREATE TABLE IF NOT EXISTS servicios (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " nombre TEXT NOT NULL,\n"
                + " contador INTEGER NOT NULL,\n"
                + " limite INTEGER NOT NULL,\n"  // La columna limite ya está definida aquí
                + " vehiculo_id INTEGER NOT NULL,\n"
                + " FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlVehiculos);
            stmt.execute(sqlServicios);
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void addLimiteColumnToServicios() {
        String url = "jdbc:sqlite:vehiculos.db";

        String sqlAlter = "ALTER TABLE servicios ADD COLUMN limite INTEGER NOT NULL DEFAULT 0;";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlAlter);
        }

        catch (SQLException e) {

        }
    }

    public static void main(String[] args) {
        createNewDatabase();  // Crear las tablas si no existen
        addLimiteColumnToServicios();  // Añadir la columna 'limite' si no está presente
    }

}
