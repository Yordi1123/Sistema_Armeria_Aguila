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
        // TODO - implement ProductoAccesorio.mostrarCatalago
        throw new UnsupportedOperationException();
    }

@Override
public String toString() {
    return "ACCESORIO: " + nombre + "\n" +
           super.toString() + "\n" +
           "Función: " + funcion;
}

}
