import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Vehículos");

        // Crear el layout principal
        VBox layout = new VBox(10);
        Scene scene = new Scene(layout, 400, 300);

        // Crear botones para las opciones
        Button btnAgregarVehiculo = new Button("Agregar Vehículo");
        Button btnListarVehiculos = new Button("Listar Vehículos");
        Button btnEditarVehiculo = new Button("Editar Vehículo");
        Button btnEliminarVehiculo = new Button("Eliminar Vehículo");
        Button btnAgregarServicio = new Button("Agregar Servicio");
        Button btnListarServicios = new Button("Listar Servicios");
        Button btnAumentarKilometraje = new Button("Aumentar Kilometraje");
        Button btnSalir = new Button("Salir");

        // Agregar los botones al layout
        layout.getChildren().addAll(
                btnAgregarVehiculo,
                btnListarVehiculos,
                btnEditarVehiculo,
                btnEliminarVehiculo,
                btnAgregarServicio,
                btnListarServicios,
                btnAumentarKilometraje,
                btnSalir
        );

        // Manejar eventos de los botones
        btnAgregarVehiculo.setOnAction(e -> agregarVehiculo());
        btnListarVehiculos.setOnAction(e -> listarVehiculos());
        btnEditarVehiculo.setOnAction(e -> editarVehiculo());
        btnEliminarVehiculo.setOnAction(e -> eliminarVehiculo());
        btnAgregarServicio.setOnAction(e -> agregarServicio());
        btnListarServicios.setOnAction(e -> listarServicios());
        btnAumentarKilometraje.setOnAction(e -> aumentarKilometraje());
        btnSalir.setOnAction(e -> primaryStage.close());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarVehiculo() {
        // Crear un nuevo diálogo
        Stage dialog = new Stage();
        dialog.setTitle("Agregar Vehículo");

        VBox dialogLayout = new VBox(10);
        TextField modeloField = new TextField();
        TextField marcaField = new TextField();
        TextField anioField = new TextField();
        TextField kilometrajeField = new TextField();

        dialogLayout.getChildren().addAll(
                new Label("Modelo:"), modeloField,
                new Label("Marca:"), marcaField,
                new Label("Año:"), anioField,
                new Label("Kilometraje:"), kilometrajeField,
                new Button("Agregar") {{
                    setOnAction(e -> {
                        String modelo = modeloField.getText();
                        String marca = marcaField.getText();
                        int anio = Integer.parseInt(anioField.getText());
                        double kilometraje = Double.parseDouble(kilometrajeField.getText());
                        System.out.println("Vehículo agregado: " + modelo + ", " + marca + ", " + anio + ", " + kilometraje);
                        dialog.close();
                    });
                }}
        );

        Scene dialogScene = new Scene(dialogLayout, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void listarVehiculos() {
        System.out.println("Listar vehículos");
    }

    private void editarVehiculo() {
        System.out.println("Editar vehículo");
    }

    private void eliminarVehiculo() {
        System.out.println("Eliminar vehículo");
    }

    private void agregarServicio() {
        System.out.println("Agregar servicio");
    }

    private void listarServicios() {
        System.out.println("Listar servicios");
    }

    private void aumentarKilometraje() {
        System.out.println("Aumentar kilometraje");
    }

    public static void main(String[] args) {
        launch(args);
    }
}