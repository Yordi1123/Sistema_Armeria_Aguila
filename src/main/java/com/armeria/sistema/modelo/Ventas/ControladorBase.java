package com.armeria.sistema.modelo.Ventas;

public abstract class ControladorBase implements Controlador {
    protected Controlador siguiente;

    @Override
    public void setSiguiente(Controlador siguiente) {
        this.siguiente = siguiente;
    }

    // Metodo para registrar un producto, que debe ser implementado por las subclases
    public abstract boolean validarRegistro(Cliente cliente, ItemVenta itemVenta);

    //Metodo para validar el siguiente controlador en la cadena
    protected boolean validarSiguiente(Cliente cliente, ItemVenta itemVenta) {
        if (siguiente == null) return true;
        return siguiente.registrarProducto(cliente, itemVenta);
    }

}
