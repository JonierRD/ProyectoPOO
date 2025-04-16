package POO.Proyecto.Controlador;

import POO.Proyecto.Modelo.Cliente;
import POO.Proyecto.Modelo.BaseDatosMemoria;
import java.util.List;

public class ClienteController {
    public static String crear(Cliente c) {
        BaseDatosMemoria.clientes.add(c);
        return "Cliente agregado";
    }

    public static List<Cliente> obtenerTodos() {
        return BaseDatosMemoria.clientes;
    }

    public static Cliente obtenerPorId(int id) {
        return BaseDatosMemoria.clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    public static boolean eliminar(int id) {
        return BaseDatosMemoria.clientes.removeIf(c -> c.getId() == id);
    }

    public static boolean actualizar(int id, Cliente nuevo) {
        for (int i = 0; i < BaseDatosMemoria.clientes.size(); i++) {
            if (BaseDatosMemoria.clientes.get(i).getId() == id) {
                BaseDatosMemoria.clientes.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
}