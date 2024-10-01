import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear base de datos y tablas
        VehiculoDAO.crearBaseDeDatos();

        Scanner scanner = new Scanner(System.in);
        Vehiculo_controlador vehiculoControlador = new Vehiculo_controlador();
        ServicioControlador servicioControlador = new ServicioControlador();

        while (true) {
            System.out.println("\n---------------\n");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Editar Vehículo");
            System.out.println("3. Eliminar Vehículo");
            System.out.println("4. Listar Vehículos");
            System.out.println("5. Agregar Servicio");
            System.out.println("6. Listar Servicios");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese año: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese kilometraje: ");
                    double kilometraje = scanner.nextDouble();
                    System.out.println("\n---------------\n");
                    vehiculoControlador.agregarVehiculo(modelo, marca, anio, kilometraje);
                    break;

                case 2:
                    System.out.print("\nIngrese ID del vehículo a editar: ");
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
                    System.out.println("\n---------------\n");
                    vehiculoControlador.editarVehiculo(idEditar, nuevoModelo, nuevaMarca, nuevoYear, nuevoKilometraje);
                    break;

                case 3:
                    System.out.print("\nIngrese ID del vehículo a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    System.out.println("---------------\n");
                    vehiculoControlador.eliminarVehiculo(idEliminar);
                    break;

                case 4:
                    System.out.println("---------------\n");
                    ArrayList<Vehiculo> vehiculos = vehiculoControlador.listarVehiculos();
                    for (Vehiculo v : vehiculos) {
                        Vista.mostrarInformacion(v);
                        System.out.println("\n---------------\n");
                    }
                    break;

                case 5:
                    System.out.print("\nIngrese nombre del servicio: ");
                    String nombreServicio = scanner.nextLine();
                    System.out.print("Ingrese contador: ");
                    int contador = scanner.nextInt();
                    System.out.print("Ingrese ID del vehículo asociado: ");
                    int vehiculoIdServicio = scanner.nextInt();
                    servicioControlador.agregarServicio(nombreServicio, contador, vehiculoIdServicio);
                    break;

                case 6:
                    System.out.print("\nIngrese ID del vehículo para listar servicios: ");
                    int idVehiculo = scanner.nextInt();
                    ArrayList<Servicio> servicios = servicioControlador.listarServicios(idVehiculo);
                    for (Servicio s : servicios) {
                        Vista.mostrarInformacion(s);
                        System.out.println("\n---------------\n");
                    }
                    break;

                case 7:
                    System.out.println("------------\n");
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("\n\n\nOpción no válida.\n");
            }
        }
    }
}
//hola