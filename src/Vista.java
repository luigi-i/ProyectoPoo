import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    private final ArrayList<Vehiculo> vehiculos;
    private final Scanner scanner;

    public Vista() {
        this.vehiculos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // metodo para agregar un vheiculo
    public void agregarVehiculo() {
        System.out.println("Ingresa el ID del vehículo: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpia el scanner

        System.out.println("Ingresa el modelo del vehículo: ");
        String modelo = scanner.nextLine();

        System.out.println("Ingresa la marca del vehículo: ");
        String marca = scanner.nextLine();

        System.out.println("Ingresa el año del vehículo: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Limpia el scanner

        System.out.println("Ingresa la cantidad de kilometros del vehículo: ");
        double km = scanner.nextDouble();

        Vehiculo vehiculo = new Vehiculo(id, modelo, marca, year, km);
        this.vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado exitosamente.");
    }

    // metodo para eliminar un vehiculo
    public void eliminarVehiculo() {
        System.out.println("Ingresa el ID del vehículo que deseas elimina(1 a  " +vehiculos.size() + "):" );
        int id= scanner.nextInt() - 1;
        if (id >= 0 && id < vehiculos.size()) {
          vehiculos.remove(id);
          System.out.println("Vehículo eliminado exitosamente.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    // metodo para buscar un vehiculo por ID
    public void buscarVehiculoPorId() {
        System.out.println("Ingresa el ID del vehículo que deseas buscar: " );
        int id= scanner.nextInt() - 1;
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getId() == id){
                mostrarInfomacion(vehiculo);
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }
    // metodo para mostrar la infomacion
    public static void mostrarInfomacion(Vehiculo vehiculo){
        System.out.println("ID: " + vehiculo.getId());
        System.out.println("Modelo: " + vehiculo.getModelo());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Año: " + vehiculo.getYear());
        System.out.println("Kilometraje: " + vehiculo.getKm());
    }
}
