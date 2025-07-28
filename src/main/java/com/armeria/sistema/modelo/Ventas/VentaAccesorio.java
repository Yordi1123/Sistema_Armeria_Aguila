// Estrategia de venta para pistolas
package com.armeria.sistema.modelo.Ventas;

public class VentaAccesorio implements EstrategiaVenta{


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
