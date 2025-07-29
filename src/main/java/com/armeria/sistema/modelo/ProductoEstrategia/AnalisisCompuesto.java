package com.armeria.sistema.modelo.ProductoEstrategia;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AnalisisCompuesto implements EstrategiaAnalisis {

    @Override
    public void analizar(List<ProductoRegistro> productos) {
        System.out.println("=== Análisis compuesto de rendimiento de productos ===");

        // Estadísticas para normalización
        IntSummaryStatistics ventasStats = productos.stream().mapToInt(ProductoRegistro::getUnidadesVendidas).summaryStatistics();
        IntSummaryStatistics diasStats = productos.stream().mapToInt(ProductoRegistro::getDiasInventario).summaryStatistics();
        DoubleSummaryStatistics margenStats = productos.stream()
            .mapToDouble(p -> p.getPrecioVenta() - p.getPrecioCosto()).summaryStatistics();

        productos.stream()
            .sorted(Comparator.comparingDouble(p -> -calcularPuntaje(p, ventasStats, diasStats, margenStats))) // orden descendente
            .forEach(p -> {
                double puntaje = calcularPuntaje(p, ventasStats, diasStats, margenStats);
                double margen = p.getPrecioVenta() - p.getPrecioCosto();
                System.out.printf("Producto: %-25s | Puntaje: %.3f | Vendidas: %3d | Días: %3d | Margen: S/ %.2f%n",
                        p.getNombre(), puntaje, p.getUnidadesVendidas(), p.getDiasInventario(), margen);
            });

        System.out.println("=== Fin del análisis compuesto ===");
    }

    private double calcularPuntaje(ProductoRegistro p,
                                    IntSummaryStatistics ventasStats,
                                    IntSummaryStatistics diasStats,
                                    DoubleSummaryStatistics margenStats) {
        // Normalizar a [0,1]
        double ventasNorm = normalize(p.getUnidadesVendidas(), ventasStats.getMin(), ventasStats.getMax());
        double diasNorm = normalize(p.getDiasInventario(), diasStats.getMin(), diasStats.getMax());
        double margen = p.getPrecioVenta() - p.getPrecioCosto();
        double margenNorm = normalize(margen, margenStats.getMin(), margenStats.getMax());

        // Puntaje ponderado
        return (ventasNorm * 0.5) + ((1 - diasNorm) * 0.3) + (margenNorm * 0.2);
    }

    private double normalize(double valor, double min, double max) {
        if (max == min) return 0.0;
        return (valor - min) / (max - min);
    }

    //  para ordenar y devolver lista
    public List<ProductoRegistro> obtenerProductosOrdenados(List<ProductoRegistro> productos) {
        IntSummaryStatistics ventasStats = productos.stream().mapToInt(ProductoRegistro::getUnidadesVendidas).summaryStatistics();
        IntSummaryStatistics diasStats = productos.stream().mapToInt(ProductoRegistro::getDiasInventario).summaryStatistics();
        DoubleSummaryStatistics margenStats = productos.stream()
            .mapToDouble(p -> p.getPrecioVenta() - p.getPrecioCosto()).summaryStatistics();

        return productos.stream()
            .sorted(Comparator.comparingDouble(p -> -calcularPuntaje(p, ventasStats, diasStats, margenStats)))
            .collect(Collectors.toList());
    }
}
