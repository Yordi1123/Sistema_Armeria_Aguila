package com.armeria.sistema.modelo.gestorInventario;//package com.armeria.sistema.modelo.gestorInventario;

public class GestorMunicion extends GestorProducto {

    public GestorMunicion() {
        super();
    }

    //Correcion de metodos por el tipo de producto adecuado
    @Override
    public void buscarPorMarca(String marca) {
        System.out.println("=== Buscando municiones de marca: " + marca + " ===");
        boolean encontrada = false;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p instanceof ProductoMunicion municion && municion.getMarca().equalsIgnoreCase(marca)) {
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
    public boolean eliminarPorNombre(String nombre) {
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                GestorProducto.getProductoArmeriaList().remove(p);
                System.out.println("Municion '" + nombre + "' eliminada del inventario.");
                return true;
            }
        }
        System.out.println("No se encontró el municion '" + nombre + "'para eliminar.");
        return false;
    }

    @Override
    public double calcularValorTotal() {
        double total = 0;
        for (ProductoArmeria p : GestorProducto.getProductoArmeriaList()) {
            total += p.precioVenta;
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
