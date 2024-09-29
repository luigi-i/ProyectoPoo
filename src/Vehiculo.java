import java.util.ArrayList;

public class Vehiculo {

    private final int id; // ID del vehículo
    private final String modelo;
    private final  String marca;
    private final int year;
    private final  double km;
    private final ArrayList<Servicio> servicios;  // Asegúrate de usar este nombre consistentemente

    public Vehiculo(int id, String modelo, String marca, int year, double km) {
        this.id = id; // se inicializa el ID
        this.modelo = modelo;
        this.marca = marca;
        this.year = year;
        this.km = km;
        this.servicios = new ArrayList<>();  // Inicializa la lista de servicios

        VehiculoDAO.insertarVehiculo(this);
    }

    // Métodos Getter
    public int getId() { return id; }
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getYear() {
        return year;
    }

    public double getKm() {
        return km;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;  // Devolver la lista de servicios
    }

    // Método para agregar un servicio
    public void addServicio(Servicio servicio) {
        servicios.add(servicio);
        VehiculoDAO.agregarServicio(id, servicio);
    }

    // Método para buscar un servicio por nombre
    public Servicio buscarServicio(String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;  // Retorna el servicio encontrado
            }
        }
        return null;  // Retorna null si no se encuentra el servicio
    }

    // Método para editar un servicio
    public boolean editarServicio(String nombre, String nuevoNombre, int nuevoContador) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            // Suponiendo que tienes setters en Servicio
            servicio.setNombre(nuevoNombre);
            servicio.setContador(nuevoContador);
            return true;  // Retorna true si se edita correctamente
        }
        return false;  // Retorna false si no se encuentra el servicio
    }

    // Método para eliminar un servicio por nombre
    public boolean eliminarServicio(String nombre) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            servicios.remove(servicio);
            return true;  // Retorna true si se elimina correctamente
        }
        return false;  // Retorna false si no se encuentra el servicio
    }
}
