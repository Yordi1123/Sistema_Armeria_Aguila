package com.armeria.sistema.modelo.gestorInventario;

public class GestorArma extends GestorProducto {

    public GestorArma() {
        super();
    }

    @Override
    public void buscarPorCodigo(String codProducto) {
        System.out.println("=== Buscando armas de marca: " + codProducto + " ===");
        boolean encontrada = false;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p instanceof ProductoArma arma && arma.getMarca().equalsIgnoreCase(codProducto)) {
                arma.mostrarDetalles();
                System.out.println("\n------------------------------------------------------");
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron armas de esa marca.");
        }
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
    public void mostrarInventario() {
        System.out.println("\n------------------------------------------------------");
        System.out.println(" INVENTARIO DE ARMAS");
        System.out.println("------------------------------------------------------");
        for (ProductoArmeria arma : GestorProducto.getProductoArmeriaList()) {
            //Comprobar que se muestre solo los productos de tipo arma
            arma.mostrarDetalles();
            System.out.println("------------------------------------------------------");
        }
    }
}