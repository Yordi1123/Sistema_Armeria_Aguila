package com.armeria.sistema.modelo.gestorInventario;
import java.util.ArrayList ;
import java.util.List ;
public abstract class GestorProducto {

    //Declarando una sola instancia de lista de productos de la armeria
    private static final List<ProductoArmeria> PRODUCTO_ARMERIA_LIST = new ArrayList<>();

    public GestorProducto () {
    }

    public static List<ProductoArmeria> getProductoArmeriaList() {
        return PRODUCTO_ARMERIA_LIST;
    }

    public void registrarProducto (ProductoArmeria producto) {
        if (producto != null ) {
            PRODUCTO_ARMERIA_LIST. add (producto);
            System. out . println ("Producto registrado: " + producto. nombre + " (" + producto. tipo + ")");
        }
    }
    public abstract void buscarPorMarca (String marca);
    public abstract boolean eliminarPorNombre (String nombre);
    public abstract double calcularValorTotal ();
    public abstract void mostrarInventario ();

    //Agregue le metodo para reducir el stock de un producto
    public void reducirStock (ProductoArmeria producto, int cantidad){
            for (ProductoArmeria prod : PRODUCTO_ARMERIA_LIST){
                if (prod.getCodProducto().equals(producto.getCodProducto()) && cantidad<prod.getStock()){
                    prod.setStock(prod.getStock()- cantidad);
                    System.out.println("Stock actualizado exitosamente");
                }else System.out.println("Operacion fallida, producto inexistente o stock insuficiente");
            }
    }


}

