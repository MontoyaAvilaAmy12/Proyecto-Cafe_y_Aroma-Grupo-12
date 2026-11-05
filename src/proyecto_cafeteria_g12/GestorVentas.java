/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cafeteria_g12;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorVentas {
    private ArrayList<Pedido> historialCompleto;

    public GestorVentas() {
        this.historialCompleto = new ArrayList<>();
    }

    public void registrarVenta(Pedido pedido) {
        historialCompleto.add(pedido);
    }

    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE VENTAS ---");
        for (Pedido p : historialCompleto) {
            System.out.println("Pedido #" + p.getNumeroPedido() + " | Total: $" + p.getTotal());
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        GestorVentas gestor = new GestorVentas();
        
        // Datos iniciales de prueba
        inventario.registrarProducto(new Bebidas("Café Americano", 2.50, 20, "Grande", true));
        inventario.registrarProducto(new Alimento("Croissant", 1.75, 15, "Bocadillo", true));
        
        System.out.println("=================================");
        System.out.println("          CAFÉ & AROMA           ");
        System.out.println("=================================");
        inventario.mostrarInventario();
    }
}
