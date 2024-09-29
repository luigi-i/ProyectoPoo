import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear base de datos y tablas
        VehiculoDAO.crearBaseDeDatos();

        Scanner scanner = new Scanner(System.in);
        Vehiculo_controlador controlador = new Vehiculo_controlador();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Editar Vehículo");
            System.out.println("3. Eliminar Vehículo");
            System.out.println("4. Listar Vehículos");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese año: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese kilometraje: ");
                    double kilometraje = scanner.nextDouble();
                    controlador.agregarVehiculo(modelo, marca, anio, kilometraje);
                    break;

                case 2:
                    System.out.print("Ingrese ID del vehículo a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Ingrese nuevo modelo: ");
                    String nuevoModelo = scanner.nextLine();
                    System.out.print("Ingrese nueva marca: ");
                    String nuevaMarca = scanner.nextLine();
                    System.out.print("Ingrese nuevo año: ");
                    int nuevoYear = scanner.nextInt();
                    System.out.print("Ingrese nuevo kilometraje: ");
                    double nuevoKilometraje = scanner.nextDouble();
                    controlador.editarVehiculo(idEditar, nuevoModelo, nuevaMarca, nuevoYear, nuevoKilometraje);
                    break;

                case 3:
                    System.out.print("Ingrese ID del vehículo a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    controlador.eliminarVehiculo(idEliminar);
                    break;

                case 4:
                    ArrayList<Vehiculo> vehiculos = controlador.listarVehiculos();
                    for (Vehiculo v : vehiculos) {
                        Vista.mostrarInformacion(v);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
