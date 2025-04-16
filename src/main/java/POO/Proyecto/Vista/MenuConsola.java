package POO.Proyecto.Vista;

import POO.Proyecto.Modelo.*;
import com.google.gson.Gson;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MenuConsola {
    private static final String API_URL = "http://localhost:4567";
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Registrar Producto");
            System.out.println("4. Registrar Factura");
            System.out.println("5. Registrar Pedido");
            System.out.println("6. Registrar Categoria");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> registrarUsuario(scanner);
                case 2 -> registrarCliente(scanner);
                case 3 -> registrarProducto(scanner);
                case 4 -> registrarFactura(scanner);
                case 5 -> registrarPedido(scanner);
                case 6 -> registrarCategoria(scanner);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("=== Registrar Usuario ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre, email);
        enviarPost("/usuarios", usuario);
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.println("=== Registrar Cliente ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(id, nombre, telefono);
        enviarPost("/clientes", cliente);
    }

    private static void registrarProducto(Scanner scanner) {
        System.out.println("=== Registrar Producto ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        Producto producto = new Producto(id, nombre, precio, cantidad);
        enviarPost("/productos", producto);
    }

    private static void registrarFactura(Scanner scanner) {
        System.out.println("=== Registrar Factura ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Simular cliente
        Cliente cliente = new Cliente(1, "Cliente demo", "0000000000");

        // Simular productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto demo", 10.0, 2));

        // Como la clase Factura no tiene campo descripción, se omite
        Factura factura = new Factura(id, cliente, productos);
        enviarPost("/facturas", factura);
    }

    private static void registrarPedido(Scanner scanner) {
        System.out.println("=== Registrar Pedido ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setDescripcion(descripcion);
        enviarPost("/pedidos", pedido);
    }

    private static void registrarCategoria(Scanner scanner) {
        System.out.println("=== Registrar Categoria ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        Categoria categoria = new Categoria(id, nombre, descripcion);
        enviarPost("/categorias", categoria);
    }

    private static void enviarPost(String endpoint, Object objeto) {
        try {
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = gson.toJson(objeto);

            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8)) {
                writer.write(json);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 201 || responseCode == 200) {
                System.out.println("✅ Registro exitoso.");
            } else {
                System.out.println("❌ Error al registrar. Código: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
