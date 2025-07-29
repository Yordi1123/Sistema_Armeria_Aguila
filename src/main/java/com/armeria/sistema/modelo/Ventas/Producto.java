package com.armeria.sistema.modelo.Ventas;

// Clase que representa un producto en el sistema de ventas (Pertenece a gestorInventario)
// Esta clase puede ser utilizada para representar tanto armas como accesorios y municiones
public class Producto {
    private String nombre;
    private TipoProducto tipo; // "Pistola", "Escopeta", "Munición", "Accesorio", etc.
    private double precioUnitario;
    private int stock;
    private String codigoSerie; // solo para armas

    // Constructor para productos con código de serie (armas)
    public Producto(String nombre, TipoProducto tipo, double precioUnitario, int stock, String codigoSerie) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.codigoSerie = codigoSerie;
    }

    // Constructor para productos sin código de serie (accesorios, municiones)
    public Producto(String nombre, TipoProducto tipo, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    // Metodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public String getCodigoSerie() {
        return codigoSerie;
    }

    public void setCodigoSerie(String codigoSerie) {
        this.codigoSerie = codigoSerie;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }



}


