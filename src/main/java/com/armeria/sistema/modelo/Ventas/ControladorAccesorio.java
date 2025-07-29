package com.armeria.sistema.modelo.Ventas;

public class ControladorAccesorio extends ControladorBase{

    // Registrar producto tipo arma, verifica si el cliente tiene licencia
    @Override
    public boolean registrarProducto(Cliente cliente, ItemVenta itemventa) {
        if (itemventa.getProducto().getTipo().equals(TipoProducto.ACCESORIO) ){

            return validarRegistro(cliente, itemventa);
        } else {
            System.out.println("El producto no un accesorio.");
        }
        return validarSiguiente(cliente, itemventa);
    }

    @Override
    public boolean validarRegistro(Cliente cliente, ItemVenta itemventa) {
        // Verifica que no se necesita licencia para comprar accesorios
        System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " puede comprar accesorios sin licencia.");
        return true;
    }
}
