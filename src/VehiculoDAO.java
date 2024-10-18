import java.sql.*;
import java.util.ArrayList;

public class VehiculoDAO {

    public static void crearBaseDeDatos() {
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
                + " limite INTEGER NOT NULL,\n" // Añadir el nuevo atributo limite
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





        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlVehiculos);
            stmt.execute(sqlServicios);
            System.out.println("Tablas creadas correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Vehiculo obtenerVehiculoPorId(int id) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "SELECT * FROM vehiculos WHERE id = ?";
        Vehiculo vehiculo = null;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo(
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("anio"),
                        rs.getDouble("kilometraje")
                );
                vehiculo.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vehiculo;
    }
    public static void actualizarKilometraje(Vehiculo v) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "UPDATE vehiculos SET kilometraje = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, v.getKilometraje());
            pstmt.setInt(2, v.getId());
            pstmt.executeUpdate();
            System.out.println("Kilometraje actualizado para el vehículo ID: " + v.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertarVehiculo(Vehiculo v) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "INSERT INTO vehiculos (modelo, marca, anio, kilometraje) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, v.getModelo());
            pstmt.setString(2, v.getMarca());
            pstmt.setInt(3, v.getYear());
            pstmt.setDouble(4, v.getKilometraje());
            pstmt.executeUpdate();

            // Obtener el ID generado
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                v.setId(rs.getInt(1));
            }

            System.out.println("Vehículo agregado: " + v.getModelo());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editarVehiculo(Vehiculo v) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "UPDATE vehiculos SET modelo = ?, marca = ?, anio = ?, kilometraje = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, v.getModelo());
            pstmt.setString(2, v.getMarca());
            pstmt.setInt(3, v.getYear());
            pstmt.setDouble(4, v.getKilometraje());
            pstmt.setInt(5, v.getId());
            pstmt.executeUpdate();
            System.out.println("Vehículo editado: " + v.getModelo());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarVehiculo(int id) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "DELETE FROM vehiculos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Vehículo eliminado con ID: " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Vehiculo> obtenerVehiculos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "SELECT * FROM vehiculos";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehiculo v = new Vehiculo(rs.getString("modelo"), rs.getString("marca"), rs.getInt("anio"), rs.getDouble("kilometraje"));
                v.setId(rs.getInt("id"));
                vehiculos.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
}
