    import java.util.ArrayList;


public class ServicioControlador {

    public void agregarServicio(int id, String nombre, int contador, int limite, int vehiculoId) {
        Servicio nuevoServicio = new Servicio(id, nombre, contador, limite, vehiculoId);
        ServicioDAO.insertarServicio(nuevoServicio);
    }

    public ArrayList<Servicio> listarServicios(int vehiculoId) {
        return ServicioDAO.obtenerServiciosPorVehiculo(vehiculoId);
    }
}
