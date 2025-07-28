package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.List;

public class AnalisisVenta implements EstrategiaAnalisis {

    @Override
    public void analizar(List<ProductoRegistro> productos) {

        System.out.println("Analizando ventas de los productos...");
        productos.stream()
        .sorted((p1, p2) -> Double.compare(p2.getPrecioVenta(), p1.getPrecioVenta()))
        .limit(5)
        .forEach(producto -> {
                System.out.println("Producto: " + producto.getNombre() + " | Precio: S/ " + producto.getPrecioVenta() + " | unidades vendidas" + producto.getUnidadesVendidas() + " | Stock " + producto.getStock());
            });
    }
}
