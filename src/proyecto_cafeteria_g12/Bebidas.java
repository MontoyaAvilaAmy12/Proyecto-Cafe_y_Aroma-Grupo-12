/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cafeteria_g12;

/**
 *
 * @author admin
 */
public class Bebidas extends Producto implements Servicio {
    private String tamano;
    private boolean esCaliente;

    public Bebidas(String nombreProducto, double precio, int stock, String tamano, boolean esCaliente) {
        super(nombreProducto, "Bebida", precio, stock);
        this.tamano = tamano;
        this.esCaliente = esCaliente;
    }

    public String getTamano() { return tamano; }
    public boolean isEsCaliente() { return esCaliente; }

    @Override
    public String obtenerTipo() {
        return "Bebida (" + (esCaliente ? "Caliente" : "Fría") + " - " + tamano + ")";
    }

    @Override
    public String preparar() {
        return "Preparando bebida " + getNombreProducto() + " de tamaño " + tamano;
    }

    
}
