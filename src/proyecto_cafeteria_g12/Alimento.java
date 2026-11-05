/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cafeteria_g12;

/**
 *
 * @author admin
 */
public class Alimento extends Producto implements Servicio {
    private String tipoAlimento;
    private boolean requiereCalentado;

    public Alimento(String nombreProducto, double precio, int stock, String tipoAlimento, boolean requiereCalentado) {
        super(nombreProducto, "Alimento", precio, stock);
        this.tipoAlimento = tipoAlimento;
        this.requiereCalentado = requiereCalentado;
    }

    public String getTipoAlimento() { return tipoAlimento; }
    public boolean isRequiereCalentado() { return requiereCalentado; }

    @Override
    public String obtenerTipo() {
        return "Alimento (" + tipoAlimento + ")";
    }

    @Override
    public String preparar() {
        return requiereCalentado ? "Calentando alimento " + getNombreProducto() : "Empacando alimento " + getNombreProducto();
    }
}