package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

public class Cliente {
        public static void main(String[] args) {
                List<ProductoArmeria> productos = new ArrayList<>();

                productos.add(new ProductoArmaRegistro("A001", "Pistol Glock 17", TipoProducto.PISTOLA, "705g", 700.0,
                                "Glock", "Glock 17", "Austria", 25, 10, 10, "9mm", 504.25));
                productos.add(new ProductoArmaRegistro("A002", "Escopeta Remington", TipoProducto.ESCOPETA, "3.5kg",
                                850.0,
                                "Remington", "870 Express", "USA", 10, 5, 20, "12ga", 630.50));

                ContextoAnalisis contexto = new ContextoAnalisis(new AnalisisRotacion());
                List<ProductoRegistro> productosRegistro = productos.stream()
                                .filter(p -> p instanceof ProductoRegistro)
                                .map(p -> (ProductoRegistro) p)
                                .collect(Collectors.toList());

                contexto.analizarProductos(productosRegistro);

                String formato = "| %-8s | %-22s | %-9s | %-6s | %-10s | %-10s | %-14s | %-12s | %-8s | %-17s | %-6s | %-15s | %-13s |\n";
                String separador = "+----------+------------------------+-----------+--------+------------+------------+----------------+--------------+----------+-------------------+--------+-----------------+---------------+";

                System.out.println(separador);
                System.out.printf(formato, "Código", "Nombre", "Tipo", "Peso", "Precio(S/)", "Marca", "Modelo",
                                "País Origen", "Calibre", "Unid. Vendidas", "Stock", "Días Inventario", "Precio Costo");
                System.out.println(separador);

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
                                                arma.getDiasInventario(),
                                                String.format("%.2f", arma.getPrecioCosto()));
                        }
                }

                System.out.println(separador);

        }
}
