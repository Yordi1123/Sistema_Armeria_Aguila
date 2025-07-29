package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.List;
import java.util.stream.Collectors;

public class AnalisisRotacion implements EstrategiaAnalisis {

    @Override
    public void analizar(List<ProductoRegistro> productos) {
        System.out.println("=== Análisis por rotación de inventario ===");

        productos.stream()
            .filter(p -> p.getDiasInventario() > 0) // evitar división por cero
            .sorted((p1, p2) -> {
                double r1 = (double) p1.getUnidadesVendidas() / p1.getDiasInventario();
                double r2 = (double) p2.getUnidadesVendidas() / p2.getDiasInventario();
                return Double.compare(r2, r1); // de mayor rotación a menor
            })
            .limit(10)
            .forEach(p -> {
                double rotacion = (double) p.getUnidadesVendidas() / p.getDiasInventario();
                System.out.printf("Producto: %-20s | Vendidas: %3d | Días: %3d | Rotación: %.2f%n",
                        p.getNombre(), p.getUnidadesVendidas(), p.getDiasInventario(), rotacion);
            });

        System.out.println("=== Fin del análisis por rotación ===");
    }

    public List<ProductoRegistro> obtenerProductosOrdenados(List<ProductoRegistro> productos) {
        return productos.stream()
            .filter(p -> p.getDiasInventario() > 0)
            .sorted((p1, p2) -> {
                double r1 = (double) p1.getUnidadesVendidas() / p1.getDiasInventario();
                double r2 = (double) p2.getUnidadesVendidas() / p2.getDiasInventario();
                return Double.compare(r2, r1);
            })
            .collect(Collectors.toList());
    }
}
