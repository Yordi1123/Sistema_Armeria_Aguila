package com.armeria.sistema.modelo.ProductoEstrategia;

public class ProductoArmaRegistro extends ProductoRegistro {
    private String calibre;

    public ProductoArmaRegistro(String codProducto, String nombre, String tipo, String peso,
                                 double precioVenta, String marca, String modelo, String paisOrigen,
                                 int unidadesVendidas, int stock, int diasInventario, String calibre) {
        super(codProducto, nombre, tipo, peso, precioVenta, marca, modelo, paisOrigen, unidadesVendidas, stock, diasInventario);
        this.calibre = calibre;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        if (calibre == null || calibre.isEmpty()) {
            throw new IllegalArgumentException("El calibre no puede ser nulo o vacío");
        }
        this.calibre = calibre;
    }

    @Override
    public void mostrarDetallesProducto() {
        System.out.println(this.toString()); 
    }

    @Override
    public String toString() {
        return "ProductoArmaRegistro {" +
                "\n  Código = '" + getCodProducto() + '\'' +
                ",\n  Nombre = '" + getNombre() + '\'' +
                ",\n  Tipo = '" + getTipo() + '\'' +
                ",\n  Peso = '" + getPeso() + '\'' +
                ",\n  Precio Venta = S/ " + getPrecioVenta() +
                ",\n  Marca = '" + getMarca() + '\'' +
                ",\n  Modelo = '" + getModelo() + '\'' +
                ",\n  País Origen = '" + getPaisOrigen() + '\'' +
                ",\n  Calibre = '" + calibre + '\'' +
                ",\n  Unidades Vendidas = " + getUnidadesVendidas() +
                ",\n  Stock = " + getStock() +
                ",\n  Días en Inventario = " + getDiasInventario() +
                "\n}";
    }
}
