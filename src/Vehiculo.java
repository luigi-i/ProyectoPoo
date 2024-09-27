import java.util.ArrayList;

public class Vehiculo {

    private String modelo;
    private String marca;
    private int year;
    private double km;
    private ArrayList<Servicio> servicios;

    public Vehiculo(String modelo, String marca, int year, double km) {
        this.modelo = modelo;
        this.marca = marca;
        this.year = year;
        this.km = km;
        this.servicios = new ArrayList<>();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    // Método para agregar un servicio
    public void addServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    // Método para buscar un servicio por nombre
    public Servicio buscarServicio(String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.getNombre().equalsIgnoreCase(nombre)) {
                return servicio;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Método para editar un servicio
    public boolean editarServicio(String nombre, String nuevoNombre, int nuevoContador) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            // Cambiar los atributos del servicio encontrado
            servicio.setNombre(nuevoNombre);
            servicio.setContador(nuevoContador);
            return true; // Edición exitosa
        }
        return false; // Edición fallida
    }

    // Método para eliminar un servicio
    public boolean eliminarServicio(String nombre) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            servicios.remove(servicio);
            return true; // Eliminación exitosa
        }
        return false; // Eliminación fallida
    }
}
