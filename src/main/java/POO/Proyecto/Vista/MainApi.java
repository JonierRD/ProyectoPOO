package POO.Proyecto.Vista;

import com.google.gson.Gson;
import static spark.Spark.*;

import POO.Proyecto.Modelo.*;
import POO.Proyecto.Controlador.*;

public class MainApi {
    public static void main(String[] args) {
        port(4567);
        Gson gson = new Gson();

        // ---------- USUARIOS ----------
        post("/usuarios", (req, res) -> {
            Usuario u = gson.fromJson(req.body(), Usuario.class);
            return UsuarioController.crear(u);
        });

        get("/usuarios", (req, res) -> gson.toJson(UsuarioController.obtenerTodos()));

        put("/usuarios/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Usuario nuevo = gson.fromJson(req.body(), Usuario.class);
            return UsuarioController.actualizar(id, nuevo) ? "Usuario actualizado" : "Usuario no encontrado";
        });

        delete("/usuarios/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return UsuarioController.eliminar(id) ? "Usuario eliminado" : "Usuario no encontrado";
        });

        // ---------- CLIENTES ----------
        post("/clientes", (req, res) -> {
            Cliente c = gson.fromJson(req.body(), Cliente.class);
            return ClienteController.crear(c);
        });

        get("/clientes", (req, res) -> gson.toJson(ClienteController.obtenerTodos()));
        get("/clientes/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Cliente cliente = ClienteController.obtenerPorId(id);
            if (cliente != null) {
                return gson.toJson(cliente);
            } else {
                res.status(404);
                return "Cliente no encontrado";
            }
        });


        put("/clientes/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Cliente nuevo = gson.fromJson(req.body(), Cliente.class);
            return ClienteController.actualizar(id, nuevo) ? "Cliente actualizado" : "Cliente no encontrado";
        });

        delete("/clientes/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return ClienteController.eliminar(id) ? "Cliente eliminado" : "Cliente no encontrado";
        });

        // ---------- PRODUCTOS ----------
        post("/productos", (req, res) -> {
            Producto p = gson.fromJson(req.body(), Producto.class);
            return ProductoController.crear(p);
        });

        get("/productos", (req, res) -> gson.toJson(ProductoController.obtenerTodos()));

        put("/productos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Producto nuevo = gson.fromJson(req.body(), Producto.class);
            return ProductoController.actualizar(id, nuevo) ? "Producto actualizado" : "Producto no encontrado";
        });

        delete("/productos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return ProductoController.eliminar(id) ? "Producto eliminado" : "Producto no encontrado";
        });

        // ---------- FACTURAS ----------
        post("/facturas", (req, res) -> {
            Factura f = gson.fromJson(req.body(), Factura.class);
            return FacturaController.crear(f);
        });

        get("/facturas", (req, res) -> gson.toJson(FacturaController.obtenerTodos()));

        put("/facturas/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Factura nuevo = gson.fromJson(req.body(), Factura.class);
            return FacturaController.actualizar(id, nuevo) ? "Factura actualizada" : "Factura no encontrada";
        });

        delete("/facturas/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return FacturaController.eliminar(id) ? "Factura eliminada" : "Factura no encontrada";
        });

        // ---------- CATEGORÍAS ----------
        post("/categorias", (req, res) -> {
            Categoria c = gson.fromJson(req.body(), Categoria.class);
            return CategoriaController.crear(c);
        });

        get("/categorias", (req, res) -> gson.toJson(CategoriaController.obtenerTodos()));

        put("/categorias/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Categoria nuevo = gson.fromJson(req.body(), Categoria.class);
            return CategoriaController.actualizar(id, nuevo) ? "Categoría actualizada" : "Categoría no encontrada";
        });

        delete("/categorias/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return CategoriaController.eliminar(id) ? "Categoría eliminada" : "Categoría no encontrada";
        });

        // ---------- PEDIDOS ----------
        post("/pedidos", (req, res) -> {
            Pedido p = gson.fromJson(req.body(), Pedido.class);
            return PedidoController.crear(p);
        });

        get("/pedidos", (req, res) -> gson.toJson(PedidoController.obtenerTodos()));

        put("/pedidos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Pedido nuevo = gson.fromJson(req.body(), Pedido.class);
            return PedidoController.actualizar(id, nuevo) ? "Pedido actualizado" : "Pedido no encontrado";
        });

        delete("/pedidos/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            return PedidoController.eliminar(id) ? "Pedido eliminado" : "Pedido no encontrado";
        });

    }
}
