package com.armeria.sistema.modelo.gestorInventario;

public class ProductoMunicion extends ProductoArmeria {
    private String calibre;
    private int cantidad;

    public ProductoMunicion(String codProducto, String nombre,
                            TipoProducto tipo, double precioUnit,
                            String marca, String modelo, int stock,
                            String calibre, int cantidad) {
        super(codProducto, nombre, tipo, precioUnit,
                marca, modelo, stock);
        this.calibre = calibre;
        this.cantidad = cantidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(" MUNICIÓN: " + nombre);
        System.out.println(" Código: " + codProducto + " | Tipo: " + tipo);
        System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Calibre: " + calibre);
        System.out.println(" Cantidad por unidad: " + cantidad );
        System.out.println(" Precio: S/ " + String.format("%.2f", precioUnit));
        System.out.println("stock disponible: " + stock);
    }

    //
    @Override
    public void mostrarCatalogo() { // Muestra el catálogo de municiones
        System.out.println("\n------------------------------------------------------");
        for (ProductoArmeria producto : GestorProducto.getProductoArmeriaList()) {
            // Verifica si el producto es de tipo munición
            if (producto.getTipo().equals(TipoProducto.MUNICION)) {
                producto.mostrarDetalles();
                System.out.println("------------------------------------------------------");
            }
        }
    }

    public int getCantidad() {
        return cantidad;
    }
}
