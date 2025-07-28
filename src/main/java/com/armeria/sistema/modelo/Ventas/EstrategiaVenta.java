// Interfaz para definir estrategias de venta
package com.armeria.sistema.modelo.Ventas;

import java.util.List;

public interface EstrategiaVenta {

    void procesarVenta(List<ItemVenta> itemList, Cliente cliente);
    double calcularTotalVenta(List<ItemVenta> itemList);
    boolean validadVenta(Cliente cliente, ItemVenta item);

}

