package com.armeria.sistema.modelo.ProductoEstrategia;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class AnalisisRotacion implements EstrategiaAnalisis {

    @Override
    public void analizar(List<ProductoRegistro> productos) {
        JTextArea area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        area.setEditable(false); // Para que no se edite
        area.append("=== Análisis por días en inventario (orden ascendente) ===\n\n");

        productos.stream()
            .sorted((p1, p2) -> Integer.compare(p1.getDiasInventario(), p2.getDiasInventario())) // menor a mayor
            .limit(10)
            .forEach(p -> {
                double rotacion = (p.getDiasInventario() > 0)
                        ? (double) p.getUnidadesVendidas() / p.getDiasInventario()
                        : 0.0;
                area.append(String.format("Producto: %-25s | Vendidas: %3d | Días: %3d | Rotación: %.2f%n",
                        p.getNombre(), p.getUnidadesVendidas(), p.getDiasInventario(), rotacion));
            });

        area.append("\n=== Fin del análisis ===");

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setPreferredSize(new Dimension(700, 300));

        JOptionPane.showMessageDialog(null, scrollPane,
                "Análisis por Días de Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<ProductoRegistro> obtenerPorDias(List<ProductoRegistro> productos) {
        return productos.stream()
            .sorted((p1, p2) -> Integer.compare(p1.getDiasInventario(), p2.getDiasInventario()))
            .collect(Collectors.toList());
    }
}
