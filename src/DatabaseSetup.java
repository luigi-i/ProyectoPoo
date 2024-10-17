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
                + " limite INTEGER NOT NULL,\n"
                + " vehiculo_id INTEGER NOT NULL,\n"
                + " FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlVehiculos);
            stmt.execute(sqlServicios);
            System.out.println("Tablas creadas correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addLimiteColumnToServicios() {
        String url = "jdbc:sqlite:vehiculos.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS servicios_temp (\n"
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " nombre TEXT NOT NULL,\n"
                    + " contador INTEGER NOT NULL,\n"
                    + " limite INTEGER NOT NULL,\n"
                    + " vehiculo_id INTEGER NOT NULL,\n"
                    + " FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)\n"
                    + ");");

            stmt.execute("INSERT INTO servicios_temp (nombre, contador, vehiculo_id) "
                    + "SELECT nombre, contador, vehiculo_id FROM servicios;");

            stmt.execute("DROP TABLE IF EXISTS servicios;");

            stmt.execute("ALTER TABLE servicios_temp RENAME TO servicios;");

            System.out.println("Columna 'limite' añadida a la tabla 'servicios' exitosamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        addLimiteColumnToServicios();
    }
}
