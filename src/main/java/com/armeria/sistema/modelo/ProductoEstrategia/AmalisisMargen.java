package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.List;

// Patron Strategy: para analizar productos de forma flexible
public class AmalisisMargen implements EstrategiaAnalisis {
    @Override
    public void analizar(List<ProductoRegistro> productos) {
        System.out.println("===Analizando márgenes de ganancia...===");
        productos.stream()
            .sorted((p1, p2) -> Double.compare(p2.getPrecioVenta(), p1.getPrecioVenta() - p1.getPrecioCosto()))
            .limit(5)
            .forEach(producto -> {
                double margen = producto.getPrecioVenta() - producto.getPrecioCosto();
                System.out.println("Producto: " + producto.getNombre() + " | Margen: S/ " + margen + " | Precio de venta: S/ " + producto.getPrecioVenta() + " | Precio de costo: S/ " + producto.getPrecioCosto());
            });
        System.out.println("===Fin del análisis de márgenes de ganancia===");
    }
}
