import java.util.ArrayList;



public class Vehiculo {

    private String modelo;
    private String marca;
    private int year;
    private double km;
    private ArrayList<Servicio> Servicios;

    public Vehiculo(String modelo,String marca, int year, double km){
        this.modelo=modelo;
        this.marca = marca;
        this.year = year;
        this.km = km;
        this.Servicios = new ArrayList<>();

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
        return Servicios;
    }

    public void addServicio(Servicio servicio) {

        Servicios.add(servicio); ;
    }
    
}
