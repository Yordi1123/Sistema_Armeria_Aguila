package com.armeria.sistema.modelo.gestorInventario;

public class ProductoMunicion extends ProductoArmeria {
    private String calibre;
    private int cantidad;

    public ProductoMunicion(String codProducto, String nombre,
                            String tipo, String peso, double precioVenta,
                            String marca, String modelo, String paisOrigen,
                            String calibre, int cantidad) {
        super(codProducto, nombre, tipo, peso, precioVenta,
                marca, modelo, paisOrigen);
        this.calibre = calibre;
        this.cantidad = cantidad;
    }

    @Override
    public void mostrarDetallesProducto() {
        System.out.println(" MUNICIÓN: " + nombre);
        System.out.println(" Código: " + codProducto + " | Tipo: " + tipo + " | Peso: " + peso + " kg");
        System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Calibre: " + calibre);
        System.out.println(" Cantidad por unidad: " + cantidad + " | Origen: " + paisOrigen);
        System.out.println(" Precio: S/ " + String.format("%.2f", precioVenta));
    }
}
