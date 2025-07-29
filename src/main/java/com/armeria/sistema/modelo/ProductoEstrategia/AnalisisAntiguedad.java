package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.List;

public class AnalisisAntiguedad implements EstrategiaAnalisis {

    @Override
    public void analizar(List<ProductoRegistro> productos) {
        System.out.println("===Analizando antigüedad de los productos...===");
        productos.stream()
            .sorted((p1, p2) -> Integer.compare(p1.getDiasInventario(), p2.getDiasInventario()))
            .limit(5)
            .forEach(producto -> {
                System.out.printf("%s - Dias en ininvetario: %d%n",
                                    producto.getNombre(),
                                    producto.getDiasInventario());
            });
        System.out.println("===Fin del análisis de antigüedad de los productos===");
    }
}
