/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_cafeteria_g12;

/**
 *
 * @author admin
 */
public abstract class Producto {
    private String nombreProducto;
    private String categoria;
    private double precio;
    private int stock;
    
    public Producto(String nombreProducto, String categoria, double precio, int stock){
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setNombreProducto(String nombreProducto){
        if (nombreProducto != null){
            this.nombreProducto = nombreProducto;
        }
    }
    
    public void setCategoria(String categoria){
        if (categoria != null){
            this.categoria = categoria;
        }
    }
    
    public void setPrecio(double precio){
        if (precio > 0){
            this.precio = precio;
        }
    }
    
    public void setStock(int stock){
        if (stock >= 0){
            this.stock = stock;
        }
    }
    
    public abstract String obtenerTipo();
    
    @Override
    public String toString() {
        return String.format("Producto: %-15s | Categoría: %-10s | Precio: $%-6.2f | Stock: %d", 
                nombreProducto, categoria, precio, stock);
    }
    
    public void mostrarDatos() {
        System.out.println(this.toString());
    }
}



