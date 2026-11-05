/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cafeteria_g12;

/**
 *
 * @author admin
 */
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto consultarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombreProducto().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
    }

    public ArrayList<Producto> getProductos() { return productos; }
}