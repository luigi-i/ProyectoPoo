class Vista {
    public static void mostrarInformacion(Vehiculo Vehiculo) {
        // Aquí solo formateamos y mostramos la información al usuario
        System.out.println("Información del Vehículo:");
        System.out.println("Marca: " + Vehiculo.getMarca());
        System.out.println("Modelo: " + Vehiculo.getModelo());
        System.out.println("Año: " + Vehiculo.getYear());
    }
    
}
