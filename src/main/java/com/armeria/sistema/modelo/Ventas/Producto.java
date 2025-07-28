package com.armeria.sistema.modelo.Ventas;

// Clase que representa un producto en el sistema de ventas (Pertenece a gestorInventario)
// Esta clase puede ser utilizada para representar tanto armas como accesorios y municiones
public class Producto {
    private String nombre;
    private String tipo; // "Pistola", "Escopeta", "Munición", "Accesorio", etc.
    private double precioUnitario;
    private int stock;
    private String codigoSerie; // solo para armas

    // Constructor, getters y setters
    public Producto(String nombre, String tipo, double precioUnitario, int stock, String codigoSerie) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.codigoSerie = codigoSerie;
    }

    public Producto(String nombre, String tipo, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
