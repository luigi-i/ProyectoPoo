public class Vista {
    public static void mostrarInformacion(Vehiculo vehiculo) {
        System.out.println("Información del Vehículo:");
        System.out.println("ID: " + vehiculo.getId());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Modelo: " + vehiculo.getModelo());
        System.out.println("Año: " + vehiculo.getYear());
        System.out.println("Kilometraje: " + vehiculo.getKilometraje());
    }

    public static void mostrarInformacion(Servicio servicio) {
        System.out.println("Información del Servicio:");
        System.out.println("Nombre: " + servicio.getNombre());
        System.out.println("Contador: " + servicio.getContador());
        System.out.println("Limite: " + servicio.getLimite()); // Mostrar límite
        System.out.println("Vehículo ID: " + servicio.getVehiculoId());
    }
}
