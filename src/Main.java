public class Main {


    public static void main(String[] args) {

        VehiculoDAO.limpiarBaseDeDatos();


        Vehiculo v1 = new Vehiculo(1, "Toyota", "Tyo", 2020, 12001);
        v1.addServicio(new Servicio("Aceite", 5000));

        Vehiculo v2 = new Vehiculo(2, "Honda", "Soul", 1990, 120002);
        v2.addServicio(new Servicio("Rotacion", 10000));
        v1.addServicio(new Servicio("Frenos", 60000));
        //todos los servicios se estan agregando al carro ID 1, posible error linea 45 de vehiculo
        //mala aplicacion del constructor


        Vista.mostrarInfomacion(v1);
        Vista.mostrarInfomacion(v2);
    }
}
