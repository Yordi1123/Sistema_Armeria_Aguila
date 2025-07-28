package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.ArrayList;
import java.util.List;
import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;

public class Cliente {
    public static void main(String[] args) {
        List<ProductoArmeria> productos = new ArrayList<>();

        productos.add(new ProductoArmaRegistro("A001", "Pistol Glock 17", "Pistola", "705g", 700.0, "Glock", "Glock 17", "Austria", 25, 10, 30, "9mm"));
        productos.add(new ProductoArmaRegistro("A002", "Beretta M9", "Pistola", "945g", 750.0, "Beretta", "M9", "Italia", 18, 12, 20, "9mm"));
        productos.add(new ProductoArmaRegistro("A003", "SIG Sauer P226", "Pistola", "964g", 820.0, "SIG Sauer", "P226", "Alemania", 22, 8, 25, "9mm"));
        productos.add(new ProductoArmaRegistro("E001", "Remington 870", "Escopeta", "3.2kg", 950.0, "Remington", "870", "EE.UU.", 15, 5, 40, "12 gauge"));
        productos.add(new ProductoArmaRegistro("E002", "Mossberg 500", "Escopeta", "3.4kg", 890.0, "Mossberg", "500", "EE.UU.", 12, 6, 35, "12 gauge"));
        productos.add(new ProductoArmaRegistro("E003", "Benelli M4", "Escopeta", "3.8kg", 1600.0, "Benelli", "M4", "Italia", 9, 4, 50, "12 gauge"));

        String formato = "| %-6s | %-20s | %-9s | %-6s | %-10s | %-9s | %-10s | %-11s | %-8s | %-18s | %-6s | %-16s |\n";

        System.out.println("+--------+----------------------+-----------+--------+------------+-----------+------------+-------------+----------+--------------------+--------+------------------+");
        System.out.printf(formato, "Código", "Nombre", "Tipo", "Peso", "Precio(S/)", "Marca", "Modelo", "País Origen", "Calibre", "Unidades Vendidas", "Stock", "Días Inventario");
        System.out.println("+--------+----------------------+-----------+--------+------------+-----------+------------+-------------+----------+--------------------+--------+------------------+");

        for (ProductoArmeria p : productos) {
            if (p instanceof ProductoArmaRegistro) {
                ProductoArmaRegistro arma = (ProductoArmaRegistro) p;
                System.out.printf(formato,
                        arma.getCodProducto(),
                        arma.getNombre(),
                        arma.getTipo(),
                        arma.getPeso(),
                        String.format("%.2f", arma.getPrecioVenta()),
                        arma.getMarca(),
                        arma.getModelo(),
                        arma.getPaisOrigen(),
                        arma.getCalibre(),
                        arma.getUnidadesVendidas(),
                        arma.getStock(),
                        arma.getDiasInventario()
                );
            }
        }

        System.out.println("+--------+----------------------+-----------+--------+------------+-----------+------------+-------------+----------+--------------------+--------+------------------+");
    }
}

