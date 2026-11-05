/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cafeteria_g12;

import java.util.ArrayList;

public class Pedido {
    private int numeroPedido;
    private ArrayList<DetallePedido> detalles;
    private double total;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            detalles.add(new DetallePedido(producto, cantidad));
            producto.setStock(producto.getStock() - cantidad);
            calcularTotal();
        } else {
            System.out.println("Stock insuficiente para: " + producto.getNombreProducto());
        }
    }

    public double calcularTotal() {
        total = 0;
        for (DetallePedido d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }

    public int getNumeroPedido() { return numeroPedido; }
    public ArrayList<DetallePedido> getDetalles() { return detalles; }
    public double getTotal() { return total; }
}
