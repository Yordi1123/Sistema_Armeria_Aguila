package com.armeria.sistema.modelo.ProductoEstrategia;
import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

public abstract class ProductoRegistro extends ProductoArmeria {
    private int unidadesVendidas;
    private int diasInventario;
    private double precioCosto;

    public ProductoRegistro(String codProducto, String nombre, TipoProducto tipo,
                            String peso, double precioVenta, String marca,
                            String modelo,  int stock, String paisOrigen, int unidadesVendidas, int diasInventario, double precioCosto) {
        super(codProducto, nombre, tipo, peso, precioVenta, marca, modelo, stock, paisOrigen);
        setUnidadesVendidas(unidadesVendidas);
        setStock(stock);
        setDiasInventario(diasInventario);
        setPrecioCosto(precioCosto);

    }
    // este get no va --> me confundi
    // este solo debe ser explusivo de ProductoArmaRegistro
    /*public String getCalibre() {
        return calibre;
    }*/

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    /*public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }*/


    public int getDiasInventario() {
        return diasInventario;
    }

    public void setDiasInventario(int diasInventario) {
        if (diasInventario < 0) {
            throw new IllegalArgumentException("Los días de inventario no pueden ser negativos");
        }
        this.diasInventario = diasInventario;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        if (codProducto == null || codProducto.isEmpty()) {
            throw new IllegalArgumentException("El código del producto no puede ser nulo o vacío");
        }
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío");     
        }
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }


    public void setPrecioVenta(double precioVenta) {
        if (precioVenta < 0) {
            throw new IllegalArgumentException("El precio de venta no puede ser negativo");     

        }
        this.precioVenta = precioVenta;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    // Corrección del metodo
    public void setTipo(TipoProducto tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de producto no puede ser nulo o vacío");
        }
        this.tipo = tipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        if (peso == null || peso.isEmpty()) {
            throw new IllegalArgumentException("El peso del producto no puede ser nulo o vacío");   
        }
    
        this.peso = peso;
    } 

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca del producto no puede ser nula o vacía");
        }
        this.marca = marca; 
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("El modelo del producto no puede ser nulo o vacío");     
        }
        this.modelo = modelo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    public void setPaisOrigen(String paisOrigen) {
        if (paisOrigen == null || paisOrigen.isEmpty()) {
            throw new IllegalArgumentException("El país de origen del producto no puede ser nulo o vacío");
        }
        this.paisOrigen = paisOrigen;       
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        if (precioCosto < 0) {
            throw new IllegalArgumentException("El precio de costo no puede ser negativo");
        }
    this.precioCosto = precioCosto;
    }
    
}
