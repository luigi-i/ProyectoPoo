public class Servicio {
    private final String nombre;
    private final int contador;
    private final int vehiculoId;

    public Servicio(String nombre, int contador, int vehiculoId) {
        this.nombre = nombre;
        this.contador = contador;
        this.vehiculoId = vehiculoId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }
}
