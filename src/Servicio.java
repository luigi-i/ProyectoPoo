public class Servicio {
    private final String nombre;
    private final int contador;

    public Servicio(String nombre, int contador) {
        this.nombre = nombre;
        this.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }
}
