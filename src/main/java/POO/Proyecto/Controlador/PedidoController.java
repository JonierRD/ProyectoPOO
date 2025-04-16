package POO.Proyecto.Controlador;

import POO.Proyecto.Modelo.Pedido;
import POO.Proyecto.Modelo.BaseDatosMemoria;
import java.util.List;

public class PedidoController {
    public static String crear(Pedido p) {
        BaseDatosMemoria.pedidos.add(p);
        return "Pedido agregado";
    }

    public static List<Pedido> obtenerTodos() {
        return BaseDatosMemoria.pedidos;
    }

    public static Pedido obtenerPorId(int id) {
        return BaseDatosMemoria.pedidos.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    public static boolean eliminar(int id) {
        return BaseDatosMemoria.pedidos.removeIf(p -> p.getId() == id);
    }

    public static boolean actualizar(int id, Pedido nuevo) {
        for (int i = 0; i < BaseDatosMemoria.pedidos.size(); i++) {
            if (BaseDatosMemoria.pedidos.get(i).getId() == id) {
                BaseDatosMemoria.pedidos.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
}