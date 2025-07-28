package com.armeria.sistema.modelo.Ventas;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private static final List<Producto> PRODUCTO_LIST = new ArrayList<>();

    public static boolean verificarDisponibilidad(String nombreProducto, int cantidad) {
        for (Producto prod : PRODUCTO_LIST){
            if (prod.getNombre().equals(nombreProducto) && cantidad<prod.getStock()){
                System.out.println("Producto disponible");
                return true;
            }
        }
        System.out.println("Producto agotado");
        return false;
    }

    public void actualizarStock(Producto producto, int cantidadVendida) {
        if (verificarDisponibilidad(producto.getNombre(),cantidadVendida)){
            producto.setStock(producto.getStock()-cantidadVendida);
            System.out.println("stock actualizado exitosamente");
        }
    }

    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto prod : PRODUCTO_LIST) {
            if (prod.getNombre().equals(nombre)) {
                return prod;
            }
        }
        return null; // Producto no encontrado
    }

}
