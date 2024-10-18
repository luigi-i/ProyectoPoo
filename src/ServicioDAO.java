import java.sql.*;
import java.util.ArrayList;

public class ServicioDAO {

    // Método para insertar un nuevo servicio
    public static void insertarServicio(Servicio servicio) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "INSERT INTO servicios (nombre, contador, limite, vehiculo_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, servicio.getNombre());
            pstmt.setInt(2, servicio.getContador());
            pstmt.setInt(3, servicio.getLimite()); // Asegúrate de que se use el nuevo atributo limite
            pstmt.setInt(4, servicio.getVehiculoId());
            pstmt.executeUpdate();
            System.out.println("Servicio agregado: " + servicio.getNombre());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para obtener todos los servicios de un vehículo específico
    public static ArrayList<Servicio> obtenerServiciosPorVehiculo(int vehiculoId) {
        ArrayList<Servicio> servicios = new ArrayList<>();
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "SELECT * FROM servicios WHERE vehiculo_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehiculoId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Asegúrate de que el constructor de Servicio acepte todos estos parámetros
                Servicio servicio = new Servicio(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("contador"),
                        rs.getInt("limite"), // Obtener el limite desde la base de datos
                        rs.getInt("vehiculo_id")
                );
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return servicios;
    }

    // Método para actualizar un servicio existente
    public static void actualizarServicio(Servicio servicio) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "UPDATE servicios SET nombre = ?, contador = ?, limite = ?, vehiculo_id = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, servicio.getNombre());
            pstmt.setInt(2, servicio.getContador());
            pstmt.setInt(3, servicio.getLimite());
            pstmt.setInt(4, servicio.getVehiculoId());
            pstmt.setInt(5, servicio.getId());  // Asumiendo que Servicio tiene un método getId
            pstmt.executeUpdate();
            System.out.println("Servicio actualizado con ID: " + servicio.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Servicio> obtenerServiciosPorVehiculoId(int vehiculoId) {
        ArrayList<Servicio> servicios = new ArrayList<>();
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "SELECT * FROM servicios WHERE vehiculo_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehiculoId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Asumiendo que el constructor de Servicio toma los parámetros en este orden
                Servicio servicio = new Servicio(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("contador"),
                        rs.getInt("limite"),
                        rs.getInt("vehiculo_id")
                );
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return servicios;
    }

}