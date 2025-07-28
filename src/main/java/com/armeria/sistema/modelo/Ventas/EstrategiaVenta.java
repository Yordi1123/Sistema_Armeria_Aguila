// Interfaz para definir estrategias de venta
package com.armeria.sistema.modelo.Ventas;

public interface EstrategiaVenta {

    void procesarVenta(Cliente cliente);

    double calcularTotalVenta(CarritoCompra carrito);

    boolean validadVenta(boolean isValido);

}

