package com.armeria.sistema.modelo.gestorInventario;//package com.armeria.sistema.modelo.gestorInventario;

public class GestorMunicion extends GestorProducto {

    public GestorMunicion() {
        super();
    }

    //Correcion de metodos por el tipo de producto adecuado
    @Override
    public void buscarPorCodigo(String codProducto) {
        System.out.println("=== Buscando municiones de marca: " + codProducto + " ===");
        boolean encontrada = false;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p instanceof ProductoMunicion municion && municion.getMarca().equalsIgnoreCase(codProducto)) {
                municion.mostrarDetalles();
                System.out.println("\n------------------------------------------------------");
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron municiones de esa marca.");
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
        System.out.println("\n------------------------------------------------------");
        System.out.println(" INVENTARIO DE MUNICIONES");
        System.out.println("------------------------------------------------------");
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p.getTipo().equals(TipoProducto.MUNICION)) {
                p.mostrarDetalles();
                System.out.println("------------------------------------------------------");
            }

        }
    }
}
