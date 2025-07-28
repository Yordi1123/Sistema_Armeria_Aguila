package com.armeria.sistema.modelo.gestorInventario;

public class ProductoMunicion extends ProductoArmeria {
    private String calibre;
    private int cantidad;

    public ProductoMunicion(String codProducto, String nombre,
                            TipoProducto tipo, String peso, double precioVenta,
                            String marca, String modelo, int stock, String paisOrigen,
                            String calibre, int cantidad) {
        super(codProducto, nombre, tipo, peso, precioVenta,
                marca, modelo, stock, paisOrigen);
        this.calibre = calibre;
        this.cantidad = cantidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(" MUNICIÓN: " + nombre);
        System.out.println(" Código: " + codProducto + " | Tipo: " + tipo + " | Peso: " + peso + " kg");
        System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Calibre: " + calibre);
        System.out.println(" Cantidad por unidad: " + cantidad + " | Origen: " + paisOrigen);
        System.out.println(" Precio: S/ " + String.format("%.2f", precioVenta));
        System.out.println("stock disponible: " + stock);
    }

    //
    @Override
    public void mostrarCatalogo() { // Muestra el catálogo de municiones
        System.out.println("\n------------------------------------------------------");
        for (ProductoArmeria producto : GestorProducto.getProductoArmeriaList()) {
            // Verifica si el producto es de tipo munición
            if (producto.getTipo() == TipoProducto.MUNICION) {
                producto.mostrarDetalles();
                System.out.println("------------------------------------------------------");
            }
        }
    }
}
