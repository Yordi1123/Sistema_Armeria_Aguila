package com.armeria.sistema.modelo.gestorInventario;

public class GestorMunicion extends GestorProducto {

    public GestorMunicion() {
        super();
    }

    @Override
    public void buscarPorMarca(String marca) {
        System.out.println("=== Buscando armas de marca: " + marca + " ===");
        boolean encontrada = false;
        for (ProductoArmeria p : inventario) {
            if (p instanceof ProductoArma arma && arma.marca.equalsIgnoreCase(marca)) {
                arma.mostrarDetallesProducto();
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
        for (ProductoArmeria p : inventario) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                inventario.remove(p);
                System.out.println("Arma '" + nombre + "' eliminada del inventario.");
                return true;
            }
        }
        System.out.println("No se encontró el arma '" + nombre + "'para eliminar.");
        return false;
    }

    @Override
    public double calcularValorTotal() {
        double total = 0;
        for (ProductoArmeria p : inventario) {
            total += p.precioVenta;
        }
        return total;
    }

    @Override
    public void mostrarInventario() {
        System.out.println("\n------------------------------------------------------");
        System.out.println(" INVENTARIO DE MUNICIONES");
        System.out.println("------------------------------------------------------");
        for (ProductoArmeria p : inventario) {
            p.mostrarDetallesProducto();
            System.out.println("------------------------------------------------------");
        }
    }
}
