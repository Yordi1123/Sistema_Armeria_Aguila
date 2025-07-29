package com.armeria.sistema.modelo.ProductoEstrategia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

public class ClienteSwing extends JFrame {

    public ClienteSwing() {
        setTitle("Productos de Armería");
        setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        List<ProductoArmeria> productos = new ArrayList<>();
        productos.add(new ProductoArmaRegistro("A001", "Pistol Glock 17", TipoProducto.PISTOLA, "705g", 700.0,
                "Glock", "Glock 17", "Austria", 25, 10, 20, "9mm", 504.25));
        productos.add(new ProductoArmaRegistro("A002", "Escopeta Remington", TipoProducto.ESCOPETA, "3.5kg",
                850.0, "Remington", "870 Express", "USA", 10, 5, 10, "12ga", 630.50));

        ContextoAnalisis contexto = new ContextoAnalisis(new AnalisisRotacion());
        List<ProductoRegistro> productosRegistro = productos.stream()
                .filter(p -> p instanceof ProductoRegistro)
                .map(p -> (ProductoRegistro) p)
                .collect(Collectors.toList());
        contexto.analizarProductos(productosRegistro);

        String[] columnas = {
                "Código", "Nombre", "Tipo", "Peso", "Precio(S/)", "Marca", "Modelo",
                "País Origen", "Calibre", "Unid. Vendidas", "Stock", "Días Inventario", "Precio Costo"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (ProductoArmeria p : productos) {
            if (p instanceof ProductoArmaRegistro arma) {
                Object[] fila = {
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
                        String.format("%.2f", arma.getPrecioCosto())
                };
                modelo.addRow(fila);
            }
        }

        JTable tabla = new JTable(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClienteSwing().setVisible(true);
        });
    }
}

