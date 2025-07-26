package com.armeria.sistema.modelo.gestorInventario;

public class ProductoArma extends ProductoArmeria {
    private String calibre;
    private double longitudCanon;
    private int capacidadCargador;
    private String seguro;

    public ProductoArma(String codProducto, String nombre,
                        String tipo, String peso,
                        double precioVenta, String marca, String modelo,
                        String paisOrigen,
                        String calibre, double longitudCanon, int capacidadCargador, String seguro) {
        super(codProducto, nombre, tipo, peso, precioVenta,
                marca, modelo, paisOrigen);
        this.calibre = calibre;
        this.longitudCanon = longitudCanon;
        this.capacidadCargador = capacidadCargador;
        this.seguro = seguro;
    }

    @Override
    public String toString(){
        return "ProductoArma{" +
                "codProducto='" + codProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", peso='" + peso + '\'' +
                ", precioVenta=" + precioVenta +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", calibre='" + calibre + '\'' +
                ", longitudCanon=" + longitudCanon +
                ", capacidadCargador=" + capacidadCargador +
                ", seguro='" + seguro + '\'' +
                '}';

    }
//     @Override
//     public void mostrarDetallesProducto() {
//         System.out.println(" ARMA: " + nombre);
//         System.out.println(" Código: " + codProducto + " | Tipo: "+ tipo + " | Peso: " + peso + " kg");
//         System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Calibre: " + calibre);
//         System.out.println(" Longitud Cañón: " + longitudCanon + " mm | Capacidad Cargador:" + capacidadCargador);
//         System.out.println(" Seguro: " + seguro + " | Origen: " + paisOrigen + " | Precio: S/ " + precioVenta);
//     }
}
