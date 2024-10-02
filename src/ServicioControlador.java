import java.util.ArrayList;

public class ServicioControlador {

    public void agregarServicio(String nombre, int contador, int vehiculoId) {
        Servicio nuevoServicio = new Servicio(nombre, contador, vehiculoId);
        ServicioDAO.insertarServicio(nuevoServicio);
    }

    public ArrayList<Servicio> listarServicios(int vehiculoId) {
        return ServicioDAO.obtenerServiciosPorVehiculo(vehiculoId);
    }
}
