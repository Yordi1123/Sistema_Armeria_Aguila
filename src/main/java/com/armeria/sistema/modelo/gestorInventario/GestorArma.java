package com.armeria.sistema.modelo.gestorInventario;

public class GestorArma extends GestorProducto {

    public GestorArma() {
        super();
    }

    @Override
    public void buscarPorMarca(String marca) {
        System.out.println("=== Buscando armas de marca: " + marca + " ===");
        boolean encontrada = false;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p instanceof ProductoArma arma && arma.getMarca().equalsIgnoreCase(marca)) {
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
    public boolean eliminarPorNombre(String nombre) {
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            //Comprobar si el producto es de tipo arma y luego hacer la comparcion
            if (p instanceof ProductoArma arma && arma.getNombre().equalsIgnoreCase(nombre)) {
                GestorProducto.getProductoArmeriaList().remove(arma);
                System.out.println("Arma '" + nombre + "' eliminada del inventario.");
                return true;
            }
        }
        System.out.println("No se encontró el arma '" + nombre + "' para eliminar.");
        return false;
    }

    @Override
    public double calcularValorTotal() {
        double total = 0;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            //Comprobar que contabililce solo los productos de tipo arma
            if (p instanceof ProductoArma arma)
                total += arma.getPrecioVenta();
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