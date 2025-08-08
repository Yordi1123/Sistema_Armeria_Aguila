package com.armeria.sistema.modelo.gestorInventario;

import java.util.Locale;

public class GestorArma extends GestorProducto {

    public GestorArma() {
        super();
    }

    @Override
    public double calcularValorTotal() {
        double total = 0;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            //Comprobar que contabililce solo los productos de tipo arma
            if (p instanceof ProductoArma arma)
                total += arma.getPrecioUnit();
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
        System.out.println("║                                           CATÁLOGO DE ARMAS                                       ║");

        System.out.println(lineaSeparadora);
        System.out.printf("║ %-5s ║ %-36s ║ %-10s ║ %-12s ║ %-8s ║ %-10s  ║%n",
                "Cod", "Nombre", "Calibre", "Precio (S/.)", "Stock", "Marca");
        System.out.println(lineaSeparadora);

        for (ProductoArmeria arma1 : GestorProducto.getProductoArmeriaList()) {;
            if (arma1.getTipo() == TipoProducto.ARMA) {
                ProductoArma arma = (ProductoArma) arma1;
                System.out.printf(Locale.US, "║ %-5s ║ %-36.36s ║ %-10s ║ %12.2f ║ %8d ║ %-11s ║%n",
                        arma.getCodProducto(),
                        arma.getNombre(),
                        arma.getCalibre(),
                        arma.getPrecioUnit(),
                        arma.getStock(),
                        arma.getMarca());
            }
        }

        System.out.println(lineaInferior);
    }



}