public class Vista {
    public static void mostrarInformacion(Vehiculo vehiculo) {
        System.out.println("Información del Vehículo:");
        System.out.println("ID: " + vehiculo.getId());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Modelo: " + vehiculo.getModelo());
        System.out.println("Año: " + vehiculo.getYear());
        System.out.println("Kilometraje: " + vehiculo.getKilometraje());
    }
}
