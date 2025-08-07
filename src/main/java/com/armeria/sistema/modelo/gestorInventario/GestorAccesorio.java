package com.armeria.sistema.modelo.gestorInventario;

import java.util.Locale;

public class GestorAccesorio extends GestorProducto {
    public GestorAccesorio() {
        super();
    }

    //Correcion del metodo por el tipo adecuado de producto
//    @Override
//    public void buscarPorCodigo(String codProducto) {
//        System.out.println("=== Buscando accesorios de marca: " + codProducto + " ===");
//        boolean encontrada = false;
//        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
//            if (p instanceof ProductoAccesorio accesorio && accesorio.getMarca().equalsIgnoreCase(codProducto)) {
//                accesorio.mostrarDetalles();
//                System.out.println("\n--------------------------------------------------------------------------");
//                encontrada = true;
//            }
//        }
//        if (!encontrada) {
//            System.out.println("No se encontraron accesorios de esa marca.");
//        }
//    }

    @Override
    public double calcularValorTotal() {
        double total = 0;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            total += p.precioUnit;
        }
        return total;
    }

    @Override
    public void mostrarCatalogo() {
        String lineaSuperior = "╔═══════╦══════════════════════════════════════╦════════════╦══════════════╦══════════╦═════════════╗";
        String lineaSeparadora = "╠═══════╬══════════════════════════════════════╬════════════╬══════════════╬══════════╬═════════════╣";
        String lineaInferior = "╚═══════╩══════════════════════════════════════╩════════════╩══════════════╩══════════╩═════════════╝";

        System.out.println();
        System.out.println(lineaSuperior);
        System.out.println("║                                           CATÁLOGO DE ACCESORIO                                   ║");

        System.out.println(lineaSeparadora);
        System.out.printf("║ %-5s ║ %-36s ║ %-10s ║ %-12s ║ %-8s ║ %-10s  ║%n",
                "Cod", "Nombre", "Modelo", "Precio (S/.)", "Stock", "Marca");
        System.out.println(lineaSeparadora);

        for (ProductoArmeria arma1 : GestorProducto.getProductoArmeriaList()) {; // Aseguramos que sea del tipo ProductoArma
            if (arma1.getTipo() == TipoProducto.ACCESORIO) {
                ProductoAccesorio arma = (ProductoAccesorio) arma1; // Hacemos el cast a ProductoArma
                System.out.printf(Locale.US, "║ %-5s ║ %-36.36s ║ %-10s ║ %12.2f ║ %8d ║ %-11s ║%n",
                        arma.getCodProducto(),
                        arma.getNombre(),
                        arma.getModelo(),    // Asumiendo getter getCalibre()
                        arma.getPrecioUnit(),
                        arma.getStock(),
                        arma.getMarca());
            }
        }

        System.out.println(lineaInferior);
    }
}

