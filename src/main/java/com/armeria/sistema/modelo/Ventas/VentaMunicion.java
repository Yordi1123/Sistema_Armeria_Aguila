// Estrategia de venta para munición

package com.armeria.sistema.modelo.Ventas;

public class VentaMunicion implements EstrategiaVenta {


    @Override
    public void procesarVenta(Cliente cliente) {

    }

    @Override
    public double calcularTotalVenta(CarritoCompra carrito) {
        return 0;
    }

    @Override
    public boolean validadVenta(boolean isValido) {
        return false;
    }
}
