import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createNewDatabase() {
        String url = "jdbc:sqlite:vehiculos.db";  // Archivo de la base de datos

        // SQL para crear la tabla de vehículos
        String sqlVehiculos = "CREATE TABLE IF NOT EXISTS vehiculos (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " modelo TEXT NOT NULL,\n"
                + " marca TEXT NOT NULL,\n"
                + " anio INTEGER NOT NULL,\n"
                + " kilometraje REAL NOT NULL\n"
                + ");";

        // SQL para crear la tabla de servicios
        String sqlServicios = "CREATE TABLE IF NOT EXISTS servicios (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " nombre TEXT NOT NULL,\n"
                + " contador INTEGER NOT NULL,\n"
                + " vehiculo_id INTEGER NOT NULL,\n"
                + " FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Crear tablas
            stmt.execute(sqlVehiculos);
            stmt.execute(sqlServicios);
            System.out.println("Tablas creadas correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase();
    }
}