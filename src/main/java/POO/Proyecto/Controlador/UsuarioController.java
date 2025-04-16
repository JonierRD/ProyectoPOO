package POO.Proyecto.Controlador;

import POO.Proyecto.Modelo.Usuario;
import POO.Proyecto.Modelo.BaseDatosMemoria;
import java.util.List;

public class UsuarioController {
    public static String crear(Usuario u) {
        BaseDatosMemoria.usuarios.add(u);
        return "Usuario agregado";
    }

    public static List<Usuario> obtenerTodos() {
        return BaseDatosMemoria.usuarios;
    }

    public static Usuario obtenerPorId(int id) {
        return BaseDatosMemoria.usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElse(null);
    }

    public static boolean eliminar(int id) {
        return BaseDatosMemoria.usuarios.removeIf(u -> u.getId() == id);
    }

    public static boolean actualizar(int id, Usuario nuevo) {
        for (int i = 0; i < BaseDatosMemoria.usuarios.size(); i++) {
            if (BaseDatosMemoria.usuarios.get(i).getId() == id) {
                BaseDatosMemoria.usuarios.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
}