package com.armeria.sistema.modelo.gestorInventario;
import com.armeria.sistema.modelo.Ventas.CarritoCompra;
import com.armeria.sistema.modelo.Ventas.ItemVenta;

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

    public static void registrarProducto (ProductoArmeria producto) {
        if (producto != null ) {
            PRODUCTO_ARMERIA_LIST. add (producto);
            System. out . println ("Producto registrado: " + producto. nombre + " (" + producto. tipo + ")");
        }
    }
    public abstract void buscarPorCodigo(String codProducto);

    // Actualiza el stock de un producto específico
    public void actualizarStock(ProductoArmeria producto, int cantidadVendida){
        producto.setStock(producto.getStock() - cantidadVendida);
        System.out.println("stock actualizado exitosamente");
    }

    // Actualiza el stock de todos los productos en el carrito de compra
    // al finalizar la compra
    public void actualizarStockGeneral(CarritoCompra carritoCompra){

        for (ItemVenta item : carritoCompra.getItemVentaList()) {
            actualizarStock(item.getProducto(), item.getCantidad());
        }

    }

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

