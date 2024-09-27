import java.util.ArrayList;

public class Vehiculo_controlador {

    private ArrayList<Vehiculo> vehiculos;

    public Vehiculo_controlador() {
        vehiculos = new ArrayList<>();
    }

    // Método para agregar un vehículo
    public void agregarVehiculo(String modelo, String marca, int year, double km) {
        Vehiculo vehiculo = new Vehiculo(modelo, marca, year, km);
        vehiculos.add(vehiculo);
    }

    // Método para agregar un servicio a un vehículo
    public boolean agregarServicio(int vehiculoIndex, Servicio servicio) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            vehiculos.get(vehiculoIndex).addServicio(servicio);
            return true; // Servicio agregado
        }
        return false; // Vehículo no encontrado
    }

    // Método para buscar un servicio en un vehículo
    public Servicio buscarServicio(int vehiculoIndex, String nombreServicio) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            return vehiculos.get(vehiculoIndex).buscarServicio(nombreServicio);
        }
        return null; // Vehículo no encontrado
    }

    // Método para editar un servicio en un vehículo
    public boolean editarServicio(int vehiculoIndex, String nombreServicio, String nuevoNombre, int nuevoContador) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            return vehiculos.get(vehiculoIndex).editarServicio(nombreServicio, nuevoNombre, nuevoContador);
        }
        return false; // Vehículo no encontrado
    }

    // Método para eliminar un servicio en un vehículo
    public boolean eliminarServicio(int vehiculoIndex, String nombreServicio) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            return vehiculos.get(vehiculoIndex).eliminarServicio(nombreServicio);
        }
        return false; // Vehículo no encontrado
    }

    // Método para obtener todos los vehículos
    public ArrayList<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
}
