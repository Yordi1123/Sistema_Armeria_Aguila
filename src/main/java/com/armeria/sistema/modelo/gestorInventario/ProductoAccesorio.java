package com.armeria.sistema.modelo.gestorInventario;

public class ProductoAccesorio extends ProductoArmeria {

    private String funcion;

    public ProductoAccesorio(String codProducto, String nombre,
            TipoProducto tipo, String peso,
            double precioVenta, String marca, String modelo, int stock,
            String paisOrigen, String funcion) {
        super(codProducto, nombre, tipo, peso, precioVenta,
                marca, modelo, stock, paisOrigen);
        this.funcion = funcion;
    }

    @Override
    public void mostrarDetalles() {
        System. out . println (" ACCESORIO: " + nombre);
        System. out . println (" Código: " + codProducto + " | Tipo: " + tipo + " | Peso: " + peso + " kg");
        System. out . println (" Marca: " + marca + " | Modelo: " + modelo + " | Función: " + funcion);
        System. out . println (" Origen: " + paisOrigen + " | Precio: S/ " + precioVenta);
        System.out.println("stock disponible: " + stock);
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
