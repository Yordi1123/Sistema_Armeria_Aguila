package com.armeria.sistema.modelo.gestorInventario;

public class ProductoAccesorio extends ProductoArmeria {

    private String funcion;

    public ProductoAccesorio(String codProducto, String nombre,
            String tipo, String peso,
            double precioVenta, String marca, String modelo,
            String paisOrigen, String funcion) {
        super(codProducto, nombre, tipo, peso, precioVenta,
                marca, modelo, paisOrigen);
        this.funcion = funcion;
    }

    public void mostrarCatalago() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void mostrarDetallesProducto() {
        System.out.println(" ACCESORIO: " + nombre);
        System.out.println(" Código: " + codProducto + " | Tipo: " + tipo + " | Peso: " + peso + " kg");
        System.out.println(" Marca: " + marca + " | Modelo: " + modelo + " | Función: " + funcion);
        System.out.println(" Origen: " + paisOrigen + " | Precio:S/ " + precioVenta);
      
    }
}
