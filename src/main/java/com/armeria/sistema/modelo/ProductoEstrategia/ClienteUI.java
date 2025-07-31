package com.armeria.sistema.modelo.ProductoEstrategia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

public class ClienteUI extends JFrame {

    public ClienteUI() {
        setTitle("Inventario de Productos");
        setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        List<ProductoArmeria> productos = cargarProductos();

        // Ejecutar análisis
        ContextoAnalisis contexto = new ContextoAnalisis(new AnalisisRotacion());
        List<ProductoRegistro> productosRegistro = productos.stream()
                .filter(p -> p instanceof ProductoRegistro)
                .map(p -> (ProductoRegistro) p)
                .collect(Collectors.toList());
        contexto.analizarProductos(productosRegistro);

        // Columnas de la tabla
        String[] columnas = {
                "Código", "Nombre", "Tipo", "Peso", "Precio(S/)", "Marca", "Modelo", "País Origen",
                "Calibre", "Unid. Vendidas", "Stock", "Días Inventario", "Precio Costo"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (ProductoArmeria p : productos) {
            if (p instanceof ProductoArmaRegistro) {
                ProductoArmaRegistro arma = (ProductoArmaRegistro) p;
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
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);
    }

    private List<ProductoArmeria> cargarProductos() {
        List<ProductoArmeria> productos = new ArrayList<>();

        productos.add(new ProductoArmaRegistro("A001", "Pistol Glock 17", TipoProducto.PISTOLA, "705g", 700.0,
                "Glock", "Glock 17", "Austria", 25, 10, 10, "9mm", 504.25));
        productos.add(new ProductoArmaRegistro("A002", "Escopeta Remington", TipoProducto.ESCOPETA, "3.5kg",
                850.0, "Remington", "870 Express", "USA", 10, 5, 20, "12ga", 630.50));
        productos.add(new ProductoArmaRegistro("A003", "Pistol Beretta 92FS", TipoProducto.PISTOLA, "945g",
                750.0, "Beretta", "92FS", "Italy", 15, 8, 12, "9mm", 520.00));
        productos.add(new ProductoArmaRegistro("A004", "Escopeta Mossberg 500", TipoProducto.ESCOPETA, "3.2kg",
                780.0, "Mossberg", "500", "USA", 12, 6, 18, "12ga", 600.00));
        productos.add(new ProductoArmaRegistro("A005", "Pistol SIG Sauer P226", TipoProducto.PISTOLA, "964g",
                820.0, "SIG Sauer", "P226", "Germany", 20, 9, 11, "9mm", 540.00));
        productos.add(new ProductoArmaRegistro("A006", "Escopeta Benelli M4", TipoProducto.ESCOPETA, "3.8kg",
                1300.0, "Benelli", "M4", "Italy", 8, 4, 15, "12ga", 950.00));
        productos.add(new ProductoArmaRegistro("A007", "Pistol CZ 75 SP-01", TipoProducto.PISTOLA, "1180g",
                770.0, "CZ", "75 SP-01", "Czech Republic", 18, 10, 9, "9mm", 550.00));
        productos.add(new ProductoArmaRegistro("A008", "Escopeta Winchester SXP", TipoProducto.ESCOPETA,
                "3.3kg", 720.0, "Winchester", "SXP", "USA", 11, 7, 13, "12ga", 580.00));
        productos.add(new ProductoArmaRegistro("A009", "Pistol Heckler & Koch VP9", TipoProducto.PISTOLA,
                "753g", 800.0, "H&K", "VP9", "Germany", 17, 8, 10, "9mm", 560.00));
        productos.add(new ProductoArmaRegistro("A010", "Escopeta Stoeger M3000", TipoProducto.ESCOPETA, "3.6kg",
                690.0, "Stoeger", "M3000", "Turkey", 9, 5, 16, "12ga", 520.00));

        return productos;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteUI ui = new ClienteUI();
            ui.setVisible(true);
        });
    }
}
