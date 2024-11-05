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

    public static String mostrarInformacion(Servicio servicio) {

        String vistaOut2 = "";

        vistaOut2 += "Información del Servicio:";
        vistaOut2 +="\nNombre: " + servicio.getNombre();
        vistaOut2 +="\nContador: " + servicio.getContador();
        vistaOut2 +="\nLimite: " + servicio.getLimite(); // Mostrar límite
        vistaOut2 +="\nVehículo ID: " + servicio.getVehiculoId();

        return vistaOut2;
    }
}
