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
        }
    }
    public static ProductoArmeria buscarPorCodigo(String codProducto){
        if (codProducto== null || codProducto.trim().isEmpty()) {
            System.out.println("Nombre de producto inválido.");
            return null;
        }

        String codigoNormalizado = codProducto.trim().toLowerCase();

        for (ProductoArmeria prod : PRODUCTO_ARMERIA_LIST) {
            if (prod.getCodProducto() != null &&
                    prod.getCodProducto().trim().toLowerCase().equals(codigoNormalizado)) {
                return prod;
            }
        }

        return null; // Producto no encontrado
    }

    // Actualiza el stock de un producto específico
    public void actualizarStock(ProductoArmeria producto, int cantidadVendida){
        producto.setStock(producto.getStock() - cantidadVendida);
    }

    // Actualiza el stock de todos los productos en el carrito de compra
    // al finalizar la compra
    public void actualizarStockGeneral(CarritoCompra carritoCompra){

        for (ItemVenta item : carritoCompra.getItemVentaList()) {
            actualizarStock(item.getProducto(), item.getCantidad());
        }
        System.out.println("stock actualizado exitosamente");
    }

    public abstract double calcularValorTotal ();
    public abstract void mostrarCatalogo();

    //Agregue le metodo para reducir el stock de un producto
    public void reducirStock (ProductoArmeria producto, int cantidad){
            for (ProductoArmeria prod : PRODUCTO_ARMERIA_LIST){
                if (prod.getCodProducto().equals(producto.getCodProducto()) && cantidad<prod.getStock()){
                    prod.setStock(prod.getStock()- cantidad);
                    System.out.println("Stock actualizado exitosamente");
                }else System.out.println("Operacion fallida, producto inexistente o stock insuficiente");
            }
    }

    public static boolean esDisponible(String codProducto, int cantidad) {
        // Validar nombre del producto
        if (codProducto == null || codProducto.trim().isEmpty()) {
            System.out.println("Error: El codigo del producto es inválido.");
            return false;
        }

        // Validar cantidad solicitada
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que cero.");
            return false;
        }

        // Normalizar el nombre del producto (sin espacios y en minúsculas)
        String codNormalizado = codProducto.trim().toLowerCase();

        // Buscar el producto
        for (ProductoArmeria prod : PRODUCTO_ARMERIA_LIST) {
            if (prod.getCodProducto()!= null &&
                    prod.getCodProducto().trim().toLowerCase().equals(codNormalizado)) {

                if (cantidad <= prod.getStock()) {
                    System.out.println("Producto disponible: " + prod.getNombre() +
                            " (Stock: " + prod.getStock() + ")");
                    return true;
                } else {
                    System.out.println("Stock insuficiente para: " + prod.getNombre() +
                            " (Stock disponible: " + prod.getStock() + ")");
                    return false;
                }
            }
        }

        // Producto no encontrado
        System.out.println("Producto no encontrado en el inventario: " + codProducto);
        return false;
    }

}

