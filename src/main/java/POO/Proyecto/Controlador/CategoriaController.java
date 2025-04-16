package POO.Proyecto.Controlador;

import POO.Proyecto.Modelo.Categoria;
import POO.Proyecto.Modelo.BaseDatosMemoria;
import java.util.List;

public class CategoriaController {
    public static String crear(Categoria c) {
        BaseDatosMemoria.categorias.add(c);
        return "Categoría agregada";
    }

    public static List<Categoria> obtenerTodos() {
        return BaseDatosMemoria.categorias;
    }

    public static Categoria obtenerPorId(int id) {
        return BaseDatosMemoria.categorias.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    public static boolean eliminar(int id) {
        return BaseDatosMemoria.categorias.removeIf(c -> c.getId() == id);
    }

    public static boolean actualizar(int id, Categoria nuevo) {
        for (int i = 0; i < BaseDatosMemoria.categorias.size(); i++) {
            if (BaseDatosMemoria.categorias.get(i).getId() == id) {
                BaseDatosMemoria.categorias.set(i, nuevo);
                return true;
            }
        }
        return false;
    }
}