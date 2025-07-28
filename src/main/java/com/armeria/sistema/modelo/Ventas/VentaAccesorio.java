// Estrategia de venta para pistolas
package com.armeria.sistema.modelo.Ventas;

import java.util.List;

public class VentaAccesorio implements EstrategiaVenta{


    @Override
    public void procesarVenta(List<ItemVenta> itemList, Cliente cliente) {

    }

    @Override
    public double calcularTotalVenta(List<ItemVenta> itemList) {
        return 0;
    }

    @Override
    public boolean validadVenta(Cliente cliente, ItemVenta item) {
        return false;
    }
}
