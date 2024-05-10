package mx.com.alura.modelo;

import java.text.DecimalFormat;

public class Producto {
    private String nombre;
    private Double precio;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return nombre + ": $" + df.format(precio);
    }
}
