package com.armeria.sistema.modelo.Ventas;

public class ControladorArma extends ControladorBase {


    // Registrar producto tipo arma, verifica si el cliente tiene licencia
    @Override
    public boolean registrarProducto(Cliente cliente, ItemVenta itemventa) {
    if (itemventa.getProducto().getTipo().equals(TipoProducto.ARMA) ){
        System.out.println("El producto es un arma.");
        return validarRegistro(cliente, itemventa);
        } else {
            System.out.println("El producto no es un arma.");
        }
        return validarSiguiente(cliente, itemventa);
    }

    @Override
    public boolean validarRegistro(Cliente cliente, ItemVenta itemventa) {
        // Verifica si el cliente tiene licencia para comprar armas
        if (cliente.isTieneLicencia()) {
            System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " tiene licencia para comprar armas.");
            return true;
        } else {
            System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " no tiene licencia para comprar armas.");
            return false;
        }
    }
}
