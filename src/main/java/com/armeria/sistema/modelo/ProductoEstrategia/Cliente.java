package com.armeria.sistema.modelo.ProductoEstrategia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

// import com.armeria.sistema.modelo.ProductoEstrategia.AnalisisRotacion;

public class Cliente {
        public static void main(String[] args) {
                List<ProductoArmeria> productos = new ArrayList<>();

                productos.add(new ProductoArmaRegistro("A001", "Pistol Glock 17", TipoProducto.PISTOLA, "705g", 700.0,
                                "Glock",
                                "Glock 17", "Austria", 25, 10, 10, "9mm", 504.25));
                productos.add(new ProductoArmaRegistro("A001", "Escopeta", TipoProducto.PISTOLA, "705g", 700.0, "Glock",
                                "Glock 17", "Austria", 25, 10, 3, "9mm", 504.25));

                ContextoAnalisis contexto = new ContextoAnalisis(new AnalisisRotacion());
                List<ProductoRegistro> productosRegistro = productos.stream()
                                .filter(p -> p instanceof ProductoRegistro)
                                .map(p -> (ProductoRegistro) p)
                                .collect(Collectors.toList());

                contexto.analizarProductos(productosRegistro);

                String formato = "| %-6s | %-20s | %-9s | %-6s | %-10s | %-9s | %-10s | %-11s | %-8s | %-18s | %-6s | %-16s | %-12s |\n";

                System.out.println(
                                "+--------+----------------------+-----------+--------+------------+-----------+------------+-------------+----------+--------------------+--------+------------------+");
                System.out.printf(formato, "Código", "Nombre", "Tipo", "Peso", "Precio(S/)", "Marca", "Modelo",
                                "País Origen",
                                "Calibre", "Unidades Vendidas", "Stock", "Días Inventario", "Precio Costo");

                System.out.println(
                                "+--------+----------------------+-----------+--------+------------+-----------+------------+-------------+----------+--------------------+--------+------------------+");

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

                System.out.println(
                                "+--------+----------------------+-----------+--------+------------+-----------+------------+-------------+----------+--------------------+--------+------------------+");
        }
}