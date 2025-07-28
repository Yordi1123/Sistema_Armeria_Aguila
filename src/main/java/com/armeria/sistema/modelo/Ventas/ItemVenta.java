package com.armeria.sistema.modelo.Ventas;

import java.util.List;

public class ItemVenta {
    private Producto producto;
    private int cantidad;

    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }


    /**
     * Calcula el subtotal del item de venta.
     *
     * @return El subtotal calculado como el precio unitario del producto multiplicado por la cantidad.
     */
    public double calcularSubtotal() {
        return producto.getPrecioUnitario() * cantidad;
    }


    // Metodos Getter y Setter
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
