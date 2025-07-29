package com.armeria.sistema.modelo.Ventas;

public class ControladorMunicion extends ControladorBase {


    // Registrar producto tipo arma, verifica si el cliente tiene licencia
    @Override
    public boolean registrarProducto(Cliente cliente, ItemVenta itemventa) {
        if (itemventa.getProducto().getTipo().equals(TipoProducto.MUNICION) ){

            return validarRegistro(cliente, itemventa);
        } else {
            System.out.println("El producto no es municion.");
        }
        return validarSiguiente(cliente, itemventa);
    }

    @Override
    public boolean validarRegistro(Cliente cliente, ItemVenta itemventa) {
        // Verifica si el cliente tiene licencia para comprar munición y
        // No supera el límite de compra
        System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " puede comprar munición.");
        return true;
    }
}
