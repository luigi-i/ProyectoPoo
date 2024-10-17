import java.sql.*;
import java.util.ArrayList;

public class ServicioDAO {

    public static void insertarServicio(Servicio servicio) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "INSERT INTO servicios (nombre, contador, vehiculo_id) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, servicio.getNombre());
            pstmt.setInt(2, servicio.getContador());
            pstmt.setInt(3, servicio.getVehiculoId());
            pstmt.executeUpdate();
            System.out.println("Servicio agregado: " + servicio.getNombre());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Servicio> obtenerServiciosPorVehiculo(int vehiculoId) {
        ArrayList<Servicio> servicios = new ArrayList<>();
        String url = "jdbc:sqlite:vehiculos.db";
        String sql = "SELECT * FROM servicios WHERE vehiculo_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehiculoId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Servicio servicio = new Servicio(rs.getString("nombre"), rs.getInt("contador"), rs.getInt("vehiculo_id"));
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return servicios;
    }
}