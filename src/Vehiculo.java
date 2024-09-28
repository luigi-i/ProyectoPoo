import java.util.ArrayList;

public class Vehiculo {

    private String modelo;
    private String marca;
    private int year;
    private double km;
    private final ArrayList<Servicio> servicios;

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

    public String getMarca() {
        return marca;
    }

    public int getYear() {
        return year;
    }

    public double getKm() {
        return km;
    }

    // Mantén los métodos de servicio
    // ...

}
