package com.armeria.sistema.modelo.gestorInventario;

public abstract class ProductoArmeria {

    protected String codProducto;
    protected String nombre;
    protected String tipo;
    protected String peso;
    protected double precioVenta;
    protected String marca;
    protected String modelo;
    protected String paisOrigen;

    public ProductoArmeria(String codProducto, String nombre,
            String tipo, String peso,
            double precioVenta, String marca, String modelo,
            String paisOrigen) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.precioVenta = precioVenta;
        this.marca = marca;
        this.modelo = modelo;
        this.paisOrigen = paisOrigen;
    }

    public abstract void mostrarDetallesProducto();
}
