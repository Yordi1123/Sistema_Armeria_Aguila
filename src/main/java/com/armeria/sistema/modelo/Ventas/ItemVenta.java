package com.armeria.sistema.modelo.Ventas;
import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;

import java.util.List;

public class ItemVenta {
    private ProductoArmeria producto;
    private int cantidad;

    public ItemVenta(ProductoArmeria producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public ItemVenta() {}

    public double calcularSubtotal() {
        return producto.getPrecioUnit() * cantidad;
    }

    // Metodos Getter y Setter
    public ProductoArmeria getProducto() {
        return producto;
    }

    public void setProducto(ProductoArmeria producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

}
