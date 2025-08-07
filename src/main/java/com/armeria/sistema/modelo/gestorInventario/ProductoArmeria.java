package com.armeria.sistema.modelo.gestorInventario;

public abstract class ProductoArmeria {

    protected String codProducto;
    protected String nombre;
    protected TipoProducto tipo;
    //protected String peso;
    protected double precioUnit;
    protected String marca;
    protected String modelo;
    protected int stock; //Agregando el stock del producto
    //protected String paisOrigen;

    public ProductoArmeria(String codProducto, String nombre,
            TipoProducto tipo, double precioUnit, String marca, String modelo, int stock) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnit = precioUnit;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
    }

    //Metodos Getter y Setters de la clase abstracta ProductoArmeria
    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

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

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //Metodo abstracto mostrar detalles para cada tipo de producto
    public abstract void mostrarDetalles();

    //Metodo para mostrar catologo de armas
    public abstract void mostrarCatalogo();


}
