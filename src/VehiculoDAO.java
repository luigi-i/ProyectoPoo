import java.sql.*;
import java.util.ArrayList;

public class VehiculoDAO {

    // Metodo para vaciar toda la base de datos y poder hacer pruebas facilmente
    public static void limpiarBaseDeDatos() {
        String url = "jdbc:sqlite:vehiculos.db";
        String sqlLimpiarVehiculos = "DELETE FROM vehiculos";
        String sqlLimpiarServicios = "DELETE FROM servicios";
        String sqlResetId = "DELETE FROM sqlite_sequence WHERE name='vehiculos'";
        String sqlResetIDService = "DELETE FROM sqlite_sequence WHERE name='servicios'";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlLimpiarServicios);  // Limpia los registros de servicios
            stmt.execute(sqlLimpiarVehiculos);  // Limpia los registros de vehiculos
            stmt.execute(sqlResetId);  // Reinicia el ID de los vehiculos cada que se borra la tabla
            stmt.execute(sqlResetIDService); // Reinicia el ID de los serivicios cada que se borra la tabla
            System.out.println("Base de datos limpiada y ID reiniciado.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Recuperar todos los vehículos y sus servicios desde la base de datos
    public static ArrayList<Vehiculo> obtenerVehiculos() {
        String url = "jdbc:sqlite:vehiculos.db";
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        String sqlVehiculos = "SELECT * FROM vehiculos";
        String sqlServicios = "SELECT * FROM servicios WHERE vehiculo_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmtVehiculo = conn.createStatement()) {

            ResultSet rsVehiculos = stmtVehiculo.executeQuery(sqlVehiculos);


            while (rsVehiculos.next()) { // Recorre todos los vehiculos
                int vehiculoId = rsVehiculos.getInt("id");
                String modelo = rsVehiculos.getString("modelo");
                String marca = rsVehiculos.getString("marca");
                int year = rsVehiculos.getInt("anio");
                double kilometraje = rsVehiculos.getDouble("kilometraje");

                Vehiculo vehiculo = new Vehiculo(vehiculoId, modelo, marca, year, kilometraje);

                //obtener los servicios para este vehículo
                PreparedStatement pstmtServicio = conn.prepareStatement(sqlServicios);
                pstmtServicio.setInt(1, vehiculoId);
                ResultSet rsServicios = pstmtServicio.executeQuery();

                while (rsServicios.next()) {
                    String nombreServicio = rsServicios.getString("nombre");
                    int contador = rsServicios.getInt("contador");
                    Servicio servicio = new Servicio(nombreServicio, contador);
                    vehiculo.addServicio(servicio);
                }

                vehiculos.add(vehiculo);  // Agregar el vehículo con sus servicios a la lista
            }

            System.out.println("Vehículos y servicios recuperados desde la base de datos.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vehiculos;
    }

    // Método para agregar un servicio a un vehículo por su Id
    public static void agregarServicio(int vehiculoId, Servicio servicio) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sqlAgregarServicio = "INSERT INTO servicios(nombre, contador, vehiculo_id) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmtServicio = conn.prepareStatement(sqlAgregarServicio)) {

            pstmtServicio.setString(1, servicio.getNombre());
            pstmtServicio.setInt(2, servicio.getContador());
            pstmtServicio.setInt(3, vehiculoId);
            pstmtServicio.executeUpdate();

            System.out.println("Servicio agregado al vehículo con ID " + vehiculoId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Agregar un vehiculo junto a sus servicios
    public static void insertarVehiculo(Vehiculo v) {
        String url = "jdbc:sqlite:vehiculos.db";
        String sqlVehiculo = "INSERT INTO vehiculos(modelo, marca, anio, kilometraje) VALUES(?, ?, ?, ?)";
        String sqlServicio = "INSERT INTO servicios(nombre, contador, vehiculo_id) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url)) {
            // Insertar el vehículo
            PreparedStatement pstmtVehiculo = conn.prepareStatement(sqlVehiculo, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmtVehiculo.setString(1, v.getModelo());
            pstmtVehiculo.setString(2, v.getMarca());
            pstmtVehiculo.setInt(3, v.getYear());
            pstmtVehiculo.setDouble(4, v.getKm());
            pstmtVehiculo.executeUpdate();

            // Crear el ID del vehiculo
            ResultSet rs = pstmtVehiculo.getGeneratedKeys();
            int vehiculoId = 0;
            if (rs.next()) {
                vehiculoId = rs.getInt(1);
            }

            // agregar sus servicios
            for (Servicio s : v.getServicios()) {
                PreparedStatement pstmtServicio = conn.prepareStatement(sqlServicio);
                pstmtServicio.setString(1, s.getNombre());
                pstmtServicio.setInt(2, s.getContador());
                pstmtServicio.setInt(3, vehiculoId);
                pstmtServicio.executeUpdate();
            }

            System.out.println("Vehículo y servicios insertados correctamente.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        // Limpiar la base de datos mientras se hacen pruebas
        limpiarBaseDeDatos();

        //
        Vehiculo v = new Vehiculo(1,"CR-V", "Honda", 2020, 12000);
        v.addServicio(new Servicio("Cambio de aceite", 1));
        v.addServicio(new Servicio("Alineación", 1));


        insertarVehiculo(v);

        // Obtener todos los vehículos y servicios
        ArrayList<Vehiculo> vehiculos = obtenerVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Vehículo: " + vehiculo.getModelo() + ", Servicios: " + vehiculo.getServicios().size());
        }

        // Agregar un nuevo servicio a un vehículo segun su ID
        agregarServicio(1, new Servicio("Cambio de frenos", 1));
    }
}


