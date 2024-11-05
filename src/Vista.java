public class Vista {
    public static String mostrarInformacion(Vehiculo vehiculo) {

        String vistaOut1 = "";
        vistaOut1 += "\nInformación del Vehículo:";
        vistaOut1 += "\nID: " + vehiculo.getId();
        vistaOut1 += "\nMarca: " + vehiculo.getMarca();
        vistaOut1 += "\nModelo: " + vehiculo.getModelo();
        vistaOut1 +="\nAño: " + vehiculo.getYear();
        vistaOut1 +="\nKilometraje: " + vehiculo.getKilometraje();

        return vistaOut1;
    }

    public static void mostrarInformacion(Servicio servicio) {
        System.out.println("Información del Servicio:");
        System.out.println("Nombre: " + servicio.getNombre());
        System.out.println("Contador: " + servicio.getContador());
        System.out.println("Limite: " + servicio.getLimite()); // Mostrar límite
        System.out.println("Vehículo ID: " + servicio.getVehiculoId());
    }
}
