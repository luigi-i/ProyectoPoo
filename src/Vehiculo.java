public class Vehiculo {
    private int id; // ID auto-generado por la base de datos
    private String modelo;
    private String marca;
    private int year;
    private double kilometraje;

    public Vehiculo(String modelo, String marca, int year, double kilometraje) {
        this.modelo = modelo;
        this.marca = marca;
        this.year = year;
        this.kilometraje = kilometraje;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }
}
