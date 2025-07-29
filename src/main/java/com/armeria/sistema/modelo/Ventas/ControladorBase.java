package com.armeria.sistema.modelo.Ventas;

public abstract class ControladorBase implements Controlador {
    protected Controlador siguiente;

    @Override
    public void setSiguiente(Controlador siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean validarRegistro(Cliente cliente, ItemVenta itemVenta);


    protected boolean validarSiguiente(Cliente cliente, ItemVenta itemVenta) {
        if (siguiente == null) return true;
        return siguiente.registrarProducto(cliente, itemVenta);
    }
}
