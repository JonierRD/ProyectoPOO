package POO.Proyecto.Controlador;

import POO.Proyecto.Modelo.Producto;
import POO.Proyecto.Modelo.BaseDatosMemoria;
import java.util.List;

public class ProductoController {
    public static String crear(Producto p) {
        BaseDatosMemoria.productos.add(p);
        return "Producto agregado";
    }

    public static List<Producto> obtenerTodos() {
        return BaseDatosMemoria.productos;
    }

    public static Producto obtenerPorId(int id) {
        return BaseDatosMemoria.productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    public static boolean eliminar(int id) {
        return BaseDatosMemoria.productos.removeIf(p -> p.getId() == id);
    }

    public static boolean actualizar(int id, Producto nuevo) {
        for (int i = 0; i < BaseDatosMemoria.productos.size(); i++) {
            if (BaseDatosMemoria.productos.get(i).getId() == id) {
                BaseDatosMemoria.productos.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
}