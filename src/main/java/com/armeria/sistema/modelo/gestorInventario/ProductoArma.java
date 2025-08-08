package com.armeria.sistema.modelo.gestorInventario;

public class ProductoArma extends ProductoArmeria {
    private String calibre;
    private double longitudCanon;
    private int capacidadCargador;
    private String seguro;
    private String peso;
    private String paisOrigen;

    public ProductoArma(String codProducto, String nombre, TipoProducto tipo,
                        double precioUnit, String marca, String modelo, int stock,
                        String calibre, double longitudCanon, int capacidadCargador,
                        String seguro, String paisOrigen, String peso) {
        super(codProducto, nombre, tipo, precioUnit, marca, modelo, stock);
        this.calibre = calibre;
        this.longitudCanon = longitudCanon;
        this.capacidadCargador = capacidadCargador;
        this.seguro = seguro;
        this.paisOrigen = paisOrigen;
        this.peso = peso;
    }

    public String getCalibre() {
        return calibre;
    }


    @Override
    public void mostrarDetalles() {
        System.out.println(" ARMA: " + nombre);
        System.out.println(" Código: " + codProducto + " | Tipo: "+ tipo + " | Peso: " + peso + " kg");
        System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Calibre: " + calibre);
        System.out.println(" Longitud Cañón: " + longitudCanon + " mm | Capacidad Cargador:" + capacidadCargador);
        System.out.println(" Seguro: " + seguro + " | Origen: " + paisOrigen + " | Precio: S/ " + precioUnit);
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
