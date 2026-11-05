/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_cafeteria_g12;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class Proyecto_Cafeteria_G12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        GestorVentas gestorVentas = new GestorVentas();
        
        // --- Carga de datos iniciales de prueba ---
        inventario.registrarProducto(new Bebidas("Café Americano", 2.50, 20, "Grande", true));
        inventario.registrarProducto(new Bebidas("Capuchino", 3.00, 15, "Mediano", true));
        inventario.registrarProducto(new Alimento("Croissant", 1.75, 10, "Pastelería", true));
        inventario.registrarProducto(new Alimento("Sándwich Jamón", 3.50, 8, "Bocadillo", false));

        int contadorPedidos = 1;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=================================");
            System.out.println("     SISTEMA CAFÉ & AROMA       ");
            System.out.println("=================================");
            System.out.println("1. Ver Inventario de Productos");
            System.out.println("2. Registrar Nuevo Producto");
            System.out.println("3. Realizar una Venta / Pedido");
            System.out.println("4. Ver Historial de Ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    inventario.mostrarInventario();
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR NUEVO PRODUCTO ---");
                    System.out.println("Tipo (1: Bebida, 2: Alimento): ");
                    int tipo = Integer.parseInt(scanner.nextLine());
                    
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    
                    System.out.print("Stock inicial: ");
                    int stock = Integer.parseInt(scanner.nextLine());

                    if (tipo == 1) {
                        System.out.print("Tamaño (Pequeño/Mediano/Grande): ");
                        String tamano = scanner.nextLine();
                        System.out.print("¿Es caliente? (true/false): ");
                        boolean esCaliente = Boolean.parseBoolean(scanner.nextLine());
                        
                        inventario.registrarProducto(new Bebidas(nombre, precio, stock, tamano, esCaliente));
                    } else if (tipo == 2) {
                        System.out.print("Tipo de alimento: ");
                        String tipoAlimento = scanner.nextLine();
                        System.out.print("¿Requiere calentado? (true/false): ");
                        boolean requiereCalentado = Boolean.parseBoolean(scanner.nextLine());
                        
                        inventario.registrarProducto(new Alimento(nombre, precio, stock, tipoAlimento, requiereCalentado));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    System.out.println("Producto registrado exitosamente.");
                    break;

                case 3:
                    System.out.println("\n--- REALIZAR NUEVO PEDIDO ---");
                    Pedido nuevoPedido = new Pedido(contadorPedidos);
                    boolean agregando = true;

                    while (agregando) {
                        inventario.mostrarInventario();
                        System.out.print("\nIngrese el nombre exacto del producto a comprar (o 'fin' para terminar): ");
                        String nombreBusqueda = scanner.nextLine();

                        if (nombreBusqueda.equalsIgnoreCase("fin")) {
                            agregando = false;
                        } else {
                            Producto prodEncontrado = inventario.consultarProducto(nombreBusqueda);
                            if (prodEncontrado != null) {
                                System.out.println("Cantidad a llevar: ");
                                int cantidad = Integer.parseInt(scanner.nextLine());
                                nuevoPedido.agregarProducto(prodEncontrado, cantidad);
                            } else {
                                System.out.println("Producto no encontrado.");
                            }
                        }
                    }

                    if (!nuevoPedido.getDetalles().isEmpty()) {
                        gestorVentas.registrarVenta(nuevoPedido);
                        contadorPedidos++;
                        System.out.println("¡Venta completada con éxito! Total a pagar: $" + nuevoPedido.getTotal());
                    } else {
                        System.out.println("Pedido cancelado o vacío.");
                    }
                    break;

                case 4:
                    gestorVentas.mostrarHistorial();
                    break;

                case 5:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema de Café & Aroma!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
