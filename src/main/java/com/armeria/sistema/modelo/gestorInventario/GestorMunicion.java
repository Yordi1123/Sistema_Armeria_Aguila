package com.armeria.sistema.modelo.gestorInventario;//package com.armeria.sistema.modelo.gestorInventario;

import java.util.Locale;

public class GestorMunicion extends GestorProducto {

    public GestorMunicion() {
        super();
    }

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
        System.out.println("║                                           CATÁLOGO DE MUNICIONES                                  ║");

        System.out.println(lineaSeparadora);
        System.out.printf("║ %-5s ║ %-36s ║ %-10s ║ %-12s ║ %-8s ║ %-10s  ║%n",
                "Cod", "Nombre", "Set", "Precio (S/.)", "Stock", "Marca");
        System.out.println(lineaSeparadora);

        for (ProductoArmeria arma1 : GestorProducto.getProductoArmeriaList()) {;
            if (arma1.getTipo() == TipoProducto.MUNICION) {
                ProductoMunicion arma = (ProductoMunicion) arma1;
                System.out.printf(Locale.US, "║ %-5s ║ %-36.36s ║ %-10s ║ %12.2f ║ %8d ║ %-11s ║%n",
                        arma.getCodProducto(),
                        arma.getNombre(),
                        arma.getCantidad(),
                        arma.getPrecioUnit(),
                        arma.getStock(),
                        arma.getMarca());
            }
        }

        System.out.println(lineaInferior);
    }
}
