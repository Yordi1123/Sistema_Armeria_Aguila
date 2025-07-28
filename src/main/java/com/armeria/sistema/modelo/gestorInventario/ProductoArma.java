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
    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }
    public double getLongitudCanon() {
        return longitudCanon;
    }
    public void setLongitudCanon(double longitudCanon) {
        if (longitudCanon <= 0) {
            throw new IllegalArgumentException("La longitud del cañón debe ser positiva");
        }
        this.longitudCanon = longitudCanon;
    }
    public int getCapacidadCargador() {
        return capacidadCargador;
    }
    public void setCapacidadCargador(int capacidadCargador) {
        if (capacidadCargador <= 0) {
            throw new IllegalArgumentException("La capacidad del cargador debe ser positiva");
        }
        this.capacidadCargador = capacidadCargador;
    }
    public String getSeguro() {
        return seguro;
    }
    public void setSeguro(String seguro) {
        if (seguro == null || seguro.isEmpty()) {
            throw new IllegalArgumentException("El seguro no puede ser nulo o vacío");
        }
        this.seguro = seguro;
    }
    public String getCodProducto() {
        return codProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }

    public String getPeso(){
        return peso;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getPaisOrigen() {
        return paisOrigen;
    }
    public void setCodProducto(String codProducto) {
        if (codProducto == null || codProducto.isEmpty()) {
            throw new IllegalArgumentException("El código del producto no puede ser nulo o vacío");
        }
        this.codProducto = codProducto;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de producto no puede ser nulo o vacío");
        }
        this.tipo = tipo;
    }
    public void setPeso(String peso) {
        if (peso == null || peso.isEmpty()) {
            throw new IllegalArgumentException("El peso del producto no puede ser nulo o vacío");
        }
        this.peso = peso;
    }
    public void setPrecioVenta(double precioVenta) {
        if (precioVenta < 0) {
            throw new IllegalArgumentException("El precio de venta no puede ser negativo");
        }
        this.precioVenta = precioVenta;
    }
    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía");
        }
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío");
        }
        this.modelo = modelo;
    }
    public void setPaisOrigen(String paisOrigen) {
        if (paisOrigen == null || paisOrigen.isEmpty()) {
            throw new IllegalArgumentException("El país de origen no puede ser nulo o vacío");
        }
        this.paisOrigen = paisOrigen;       
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
