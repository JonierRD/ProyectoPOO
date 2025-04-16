package POO.Proyecto.Controlador;

import POO.Proyecto.Modelo.Factura;
import POO.Proyecto.Modelo.BaseDatosMemoria;
import java.util.List;

public class FacturaController {
    public static String crear(Factura f) {
        BaseDatosMemoria.facturas.add(f);
        return "Factura agregada";
    }

    public static List<Factura> obtenerTodos() {
        return BaseDatosMemoria.facturas;
    }

    public static Factura obtenerPorId(int id) {
        return BaseDatosMemoria.facturas.stream()
                .filter(f -> f.getId() == id)
                .findFirst().orElse(null);
    }

    public static boolean eliminar(int id) {
        return BaseDatosMemoria.facturas.removeIf(f -> f.getId() == id);
    }

    public static boolean actualizar(int id, Factura nuevo) {
        for (int i = 0; i < BaseDatosMemoria.facturas.size(); i++) {
            if (BaseDatosMemoria.facturas.get(i).getId() == id) {
                BaseDatosMemoria.facturas.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
}