import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            // Crear base de datos y tablas
            VehiculoDAO.crearBaseDeDatos();

            Scanner scanner = new Scanner(System.in);
            Vehiculo_controlador vehiculoControlador = new Vehiculo_controlador();
            ServicioControlador servicioControlador = new ServicioControlador();
            System.out.println("\033c");

            boolean seguir = true;

            while (seguir) {
                System.out.println("\n---------------\n");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Agregar Vehículo");
                System.out.println("2. Editar Vehículo");
                System.out.println("3. Eliminar Vehículo");
                System.out.println("4. Listar Vehículos");
                System.out.println("5. Agregar Servicio");
                System.out.println("6. Listar Servicios");
                System.out.println("7. Aumentar Kilometraje");
                System.out.println("8. Salir");


                int opcion = 0;
                try {
                    opcion = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\033c");
                    System.out.println("Introduzca un numero");
                }
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:

                        boolean case1Go = true; //si se ingresa un dato mal, se vuelve false y la operacion no se ejecuta
                        System.out.print("\nIngrese modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Ingrese marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Ingrese año: ");
                        int anio = 0; double kilometraje = 0;
                        try {
                            anio = scanner.nextInt();
                            System.out.print("Ingrese kilometraje: ");
                            kilometraje = scanner.nextDouble();
                        }catch (InputMismatchException e) {
                            System.out.println("\033c");
                            System.out.println("\nPor favor, ingrese un numero en donde se le solicite");
                            case1Go = false;
                            scanner.nextLine();
                        }


                        System.out.println("\n---------------\n");

                        if (case1Go){
                            System.out.println("\033c");
                            System.out.println(vehiculoControlador.agregarVehiculo(modelo, marca, anio, kilometraje));}

                        break;

                    case 2:
                        boolean case2Go = true;
                        int idEditar = 0; String nuevoModelo = "";
                        String nuevaMarca = ""; int nuevoYear = 0;
                        double nuevoKilometraje = 0;
                        try {
                            System.out.print("\nIngrese ID del vehículo a editar: ");
                            idEditar = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el buffer
                            System.out.print("Ingrese nuevo modelo: ");
                            nuevoModelo = scanner.nextLine();
                            System.out.print("Ingrese nueva marca: ");
                            nuevaMarca = scanner.nextLine();
                            System.out.print("Ingrese nuevo año: ");
                            nuevoYear = scanner.nextInt();
                            System.out.print("Ingrese nuevo kilometraje: ");
                             nuevoKilometraje = scanner.nextDouble();
                        }catch (InputMismatchException e) {
                            System.out.println("\033c");
                            System.out.println("\nPor favor, ingrese un numero en donde se le solicite");
                            System.out.println("Si no conoce el ID de su vehiculo, puede buscarlo con la opcion 4");
                            case2Go = false;
                            scanner.nextLine();
                        }

                        System.out.println("\n---------------\n");

                        if (case2Go) {
                            System.out.println("\033c");
                            System.out.println(vehiculoControlador.editarVehiculo(idEditar, nuevoModelo, nuevaMarca, nuevoYear, nuevoKilometraje));
                        }
                        break;

                    case 3:

                        boolean case3Go = true;
                        int idEliminar = 0;
                        try {
                            System.out.print("\nIngrese ID del vehículo a eliminar: ");
                            idEliminar = scanner.nextInt();
                        } catch (InputMismatchException e){
                            System.out.println("\033c");
                            System.out.println("\nPor favor, ingrese un numero en donde se le solicite");
                            System.out.println("Si no conoce el ID de su vehiculo, puede buscarlo con la opcion 4");
                            case3Go = false;
                            scanner.nextLine();
                        }
                        System.out.println("---------------\n");


                        if (case3Go) {
                            System.out.println("\033c");
                            System.out.println(vehiculoControlador.eliminarVehiculo(idEliminar));
                        }
                        break;

                    case 4:
                        System.out.println("---------------\n");
                        ArrayList<Vehiculo> vehiculos = vehiculoControlador.listarVehiculos();
                        for (Vehiculo v : vehiculos) {
                            System.out.println(Vista.mostrarInformacion(v));
                            System.out.println("\n---------------\n");
                        }
                        break;

                    case 5:

                        boolean case5Go = true;
                        int idServicio = 0; String nombreServicio = "";
                        int contador = 0; int limite = 0;
                        int vehiculoIdServicio = 0;
                        try {
                            System.out.print("\nIngrese ID del servicio (0 para nuevo servicio): ");
                            idServicio = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Ingrese nombre del servicio: ");
                            nombreServicio = scanner.nextLine();
                            System.out.print("Ingrese contador: ");
                            contador = scanner.nextInt();
                            System.out.print("Ingrese límite: ");
                            limite = scanner.nextInt();
                            System.out.print("Ingrese ID del vehículo asociado: ");
                            vehiculoIdServicio = scanner.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("\033c");
                            case5Go = false;
                            scanner.nextLine();
                            System.out.println("\nPor favor, ingrese un numero en donde se le solicite");
                            System.out.println("Si no conoce el ID de su vehiculo, puede buscarlo con la opcion 4");
                        }


                        if (case5Go) {
                            System.out.println("\033c");
                            System.out.println(servicioControlador.agregarServicio(idServicio, nombreServicio, contador, limite, vehiculoIdServicio));
                        }
                        break;

                    case 6:
                        boolean case6Go = true;
                        int idVehiculo = 0;
                        try {
                        System.out.print("\nIngrese ID del vehículo para listar servicios: ");
                        idVehiculo = scanner.nextInt(); }
                        catch (InputMismatchException e){
                            System.out.println("\033c");
                            System.out.println("\nPor favor, ingrese un numero en donde se le solicite");
                            System.out.println("Si no conoce el ID de su vehiculo, puede buscarlo con la opcion 4");
                            case6Go = false;
                            scanner.nextLine();
                        }
                        if (case6Go) {
                            System.out.println("\033c");
                            ArrayList<Servicio> servicios = servicioControlador.listarServicios(idVehiculo);
                            for (Servicio s : servicios) {
                                System.out.println(Vista.mostrarInformacion(s));
                                System.out.println("\n---------------\n");
                            }
                        }
                        break;
                    case 7:
                        boolean case7Go = true;

                        int idVehiculoKm = 0; double kmAumentar = 0;
                        try {
                            System.out.print("\nIngrese ID del vehículo: ");
                            idVehiculoKm = scanner.nextInt();
                            System.out.print("Ingrese la cantidad de kilómetros a aumentar: ");
                            kmAumentar = scanner.nextDouble();
                        } catch (InputMismatchException e){
                            System.out.println("\nPor favor, ingrese un numero en donde se le solicite");
                            System.out.println("Si no conoce el ID de su vehiculo, puede buscarlo con la opcion 4");
                            System.out.println("\033c");
                            case7Go = false;
                            scanner.nextLine();
                        }

                        if (case7Go) {
                            System.out.println("\033c");
                            System.out.println(vehiculoControlador.aumentarKilometraje(idVehiculoKm, kmAumentar));
                        }
                        break;
                    case 8:
                        System.out.println("------------\n");
                        System.out.println("\033c");
                        System.out.println("Saliendo...");
                        scanner.close();
                        seguir = false;
                        return;
                    default:
                        System.out.println("\n\n\nOpción no válida.\n");
                }
            }
        }

    }
