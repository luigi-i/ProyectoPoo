import java.util.List;
import java.util.ArrayList;


public class Vehiculo {
    private String modelo;
    private int Cantidad_de_servicios;
    private String marca;
    private int year;
    private int km;
    private int id;
    private List<Servicio> Servicio;

    public void Vehiculo(String modelo,int Cantidad_de_servicios,String marca, int year, int km, int id){
        this.modelo=modelo;
        this.marca = marca;
        this.year = year;
        this.km = km;
        this.id = id;
        this.Servicio=new ArrayList<>();

    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCantidad_de_servicios() {
        return Cantidad_de_servicios;
    }
    public void setCantidad_de_servicios(int cantidad_de_servicios) {
        Cantidad_de_servicios = cantidad_de_servicios;
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
    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Servicio> getServicio() {
        return Servicio;
    }
    public void setServicio(List<Servicio> servicio) {
        Servicio = servicio;
    }
    
}
