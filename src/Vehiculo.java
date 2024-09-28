import java.util.ArrayList;

public class Vehiculo {

    private String modelo;
    private String marca;
    private int year;
    private double km;
    private final ArrayList<Servicio> servicios; // Marcado como final

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
        this.modelo = modelo; // Este setter puede ser utilizado si se desea cambiar el modelo después
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca; // Este setter puede ser utilizado si se desea cambiar la marca después
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year; // Este setter puede ser utilizado si se desea cambiar el año después
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km; // Este setter puede ser utilizado si se desea cambiar el kilometraje después
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void addServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public Servicio buscarServicio(String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.getNombre().equalsIgnoreCase(nombre)) {
                return servicio;
            }
        }
        return null;
    }

    public boolean editarServicio(String nombre, String nuevoNombre, int nuevoContador) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            servicio.setNombre(nuevoNombre);
            servicio.setContador(nuevoContador);
            return true;
        }
        return false;
    }

    public boolean eliminarServicio(String nombre) {
        Servicio servicio = buscarServicio(nombre);
        if (servicio != null) {
            servicios.remove(servicio);
            return true;
        }
        return false;
    }
}
