package com.armeria.sistema.modelo.gestorInventario;

public class ProductoAccesorio extends ProductoArmeria {

    private String funcion;

    public ProductoAccesorio(String codProducto, String nombre,
            TipoProducto tipo,
            double precioUnit, String marca, String modelo, int stock, String funcion) {
        super(codProducto, nombre, tipo, precioUnit,
                marca, modelo, stock);
        this.funcion = funcion;
    }

    @Override
    public void mostrarDetalles() {
        System. out . println (" ACCESORIO: " + nombre);
        System. out . println (" Código: " + codProducto + " | Tipo: " + tipo + " |");
        System. out . println (" Marca: " + marca + " | Modelo: " + modelo + " | Función: " + funcion);
        System. out . println (" Precio: S/ " + precioUnit + " | stock disponible: " + stock);
    }

    @Override
    public void mostrarCatalogo() {// Muestra el catálogo de accesorios
        System.out.println("\n------------------------------------------------------");
        for (ProductoArmeria producto : GestorProducto.getProductoArmeriaList()) {
            // Verifica si el producto es un accesorio
            if (producto.getTipo() == TipoProducto.ACCESORIO) {
                producto.mostrarDetalles();
                System.out.println("------------------------------------------------------");
            }
        }
    }

}
