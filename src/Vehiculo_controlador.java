import java.util.ArrayList;

public class Vehiculo_controlador {

    private final ArrayList<Vehiculo> vehiculos;

    public Vehiculo_controlador() {
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(String modelo, String marca, int year, double km) {
        Vehiculo vehiculo = new Vehiculo(modelo, marca, year, km);
        vehiculos.add(vehiculo);
    }

    public ArrayList<Vehiculo> obtenerVehiculos() {
        return vehiculos;  // Retorna la lista de vehículos
    }

    public void agregarServicio(int vehiculoIndex, Servicio servicio) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            vehiculos.get(vehiculoIndex).addServicio(servicio);
        }
    }

    public Servicio buscarServicio(int vehiculoIndex, String nombreServicio) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            return vehiculos.get(vehiculoIndex).buscarServicio(nombreServicio);
        }
        return null;
    }

    public boolean editarServicio(int vehiculoIndex, String nombreServicio, String nuevoNombre, int nuevoContador) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            return vehiculos.get(vehiculoIndex).editarServicio(nombreServicio, nuevoNombre, nuevoContador);
        }
        return false;
    }

    public boolean eliminarServicio(int vehiculoIndex, String nombreServicio) {
        if (vehiculoIndex >= 0 && vehiculoIndex < vehiculos.size()) {
            return vehiculos.get(vehiculoIndex).eliminarServicio(nombreServicio);
        }
        return false;
    }
}
 //amo a lui
