package POO.Proyecto.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;

    // Constructor con ID, cliente y productos
    public Factura(int id, Cliente cliente, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
    }

    // Constructor con solo cliente (para consola)
    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public Factura() {
        this.productos = new ArrayList<>();
    }

    // Agregar producto a la factura
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Calcular total de la factura
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + calcularTotal() +
                '}';
    }
}
