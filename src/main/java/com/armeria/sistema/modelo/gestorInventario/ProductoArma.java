package com.armeria.sistema.modelo.gestorInventario;

public class ProductoArma extends ProductoArmeria {
    private String calibre;
    private double longitudCanon;
    private int capacidadCargador;
    private String seguro;

    public ProductoArma(String codProducto, String nombre,
                        TipoProducto tipo, String peso,
                        double precioVenta, String marca, String modelo, int stock,
                        String paisOrigen,
                        String calibre, double longitudCanon, int capacidadCargador, String seguro) {
        super(codProducto, nombre, tipo, peso, precioVenta,
                marca, modelo, stock, paisOrigen);
        this.calibre = calibre;
        this.longitudCanon = longitudCanon;
        this.capacidadCargador = capacidadCargador;
        this.seguro = seguro;
    }

    public String getCalibre() {
        return calibre;
    }

    public double getLongitudCanon() {
        return longitudCanon;
    }

    public int getCapacidadCargador() {
        return capacidadCargador;
    }

    public String getSeguro() {
        return seguro;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(" ARMA: " + nombre);
        System.out.println(" Código: " + codProducto + " | Tipo: "+ tipo + " | Peso: " + peso + " kg");
        System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Calibre: " + calibre);
        System.out.println(" Longitud Cañón: " + longitudCanon + " mm | Capacidad Cargador:" + capacidadCargador);
        System.out.println(" Seguro: " + seguro + " | Origen: " + paisOrigen + " | Precio: S/ " + precioVenta);
        System.out.println("stock disponible: " + stock);
    }

    @Override
    public void mostrarCatalogo() { // Muestra el catálogo de armas
        System.out.println("\n------------------------------------------------------");
        for (ProductoArmeria producto : GestorProducto.getProductoArmeriaList()) {
            // Verifica si el producto es una instancia de ProductoArma
            if (producto instanceof ProductoArma arma) {
                arma.mostrarDetalles();
                System.out.println("------------------------------------------------------");
            }
        }

    }
}
