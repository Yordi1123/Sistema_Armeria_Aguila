package com.armeria.sistema.modelo.Ventas;

import java.util.List;

public class ItemVenta {
    private Producto producto;
    private int cantidad;
    private double impuesto;

    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }


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

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
}
