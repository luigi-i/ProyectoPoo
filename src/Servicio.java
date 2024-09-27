public class Servicio {

    private String nombre;
    private int contador;

    public Servicio(String nombre, int contador) {
        this.nombre = nombre;
        this.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
