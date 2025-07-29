package com.armeria.sistema.modelo.Ventas;

public interface Controlador {
    void setSiguiente(Controlador siguiente);
    boolean registrarProducto(Cliente cliente, ItemVenta itemVenta);
}
