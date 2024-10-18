public class Servicio {
    private int id;
    private String nombre;
    private int contador;
    private int limite;
    private int vehiculoId;

    public Servicio(int id, String nombre, int contador, int limite, int vehiculoId) {
        this.id = id;
        this.nombre = nombre;
        this.contador = contador;
        this.limite = limite;
        this.vehiculoId = vehiculoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
}
