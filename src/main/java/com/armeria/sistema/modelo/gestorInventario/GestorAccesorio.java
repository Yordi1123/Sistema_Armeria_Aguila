package com.armeria.sistema.modelo.gestorInventario;

public class GestorAccesorio extends GestorProducto {
    public GestorAccesorio() {
        super();
    }

    //Correcion del metodo por el tipo adecuado de producto
    @Override
    public void buscarPorCodigo(String codProducto) {
        System.out.println("=== Buscando accesorios de marca: " + codProducto + " ===");
        boolean encontrada = false;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p instanceof ProductoAccesorio accesorio && accesorio.getMarca().equalsIgnoreCase(codProducto)) {
                accesorio.mostrarDetalles();
                System.out.println("\n--------------------------------------------------------------------------");
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron accesorios de esa marca.");
        }
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
    public void mostrarInventario() {
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println(" INVENTARIO DE ACCESORIOS");
        System.out.println("--------------------------------------------------------------------------");
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            // Comprobar que se muestre solo los productos de tipo accesorio
            if (p.getTipo().equals(TipoProducto.ACCESORIO) ){
                p.mostrarDetalles();
                System.out.println("--------------------------------------------------------------------------");
            }
        }
    }
}

