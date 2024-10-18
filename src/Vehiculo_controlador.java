import java.util.ArrayList;

public class Vehiculo_controlador {
    public void agregarVehiculo(String modelo, String marca, int year, double km) {
        // Crear el nuevo vehículo
        Vehiculo nuevoVehiculo = new Vehiculo(modelo, marca, year, km);

        // Llamar al DAO para insertar el vehículo
        VehiculoDAO.insertarVehiculo(nuevoVehiculo);

        // Mostrar información al usuario
        Vista.mostrarInformacion(nuevoVehiculo);
    }

    public void editarVehiculo(int id, String nuevoModelo, String nuevaMarca, int nuevoYear, double nuevoKm) {
        // Crear el objeto Vehiculo con el ID a editar
        Vehiculo vehiculoEditar = new Vehiculo(nuevoModelo, nuevaMarca, nuevoYear, nuevoKm);
        vehiculoEditar.setId(id);

        // Llamar al DAO para editar el vehículo
        VehiculoDAO.editarVehiculo(vehiculoEditar);
    }

    public void eliminarVehiculo(int id) {
        // Llamar al DAO para eliminar el vehículo
        VehiculoDAO.eliminarVehiculo(id);
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return VehiculoDAO.obtenerVehiculos();
    }

    public void aumentarKilometraje(int id, double kmAumentar) {
        // Obtener el vehículo por ID
        Vehiculo vehiculo = VehiculoDAO.obtenerVehiculoPorId(id);

        // Verificar que el vehículo exista
        if (vehiculo != null) {
            // Aumentar el kilometraje del vehículo
            vehiculo.setKilometraje(vehiculo.getKilometraje() + kmAumentar);

            // Actualizar en la base de datos
            VehiculoDAO.actualizarKilometraje(vehiculo);
            System.out.println("Kilometraje del vehículo actualizado: " + vehiculo.getKilometraje());

            // Actualizar kilometraje de los servicios asociados
            ArrayList<Servicio> servicios = ServicioDAO.obtenerServiciosPorVehiculoId(vehiculo.getId());
            for (Servicio servicio : servicios) {
                servicio.setContador(servicio.getContador() + (int) kmAumentar); // Ajusta según necesites
                ServicioDAO.actualizarServicio(servicio); // Método que necesitas implementar para actualizar el servicio
            }
        }
    }
}