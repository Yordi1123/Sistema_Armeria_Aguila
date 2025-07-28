package com.armeria.sistema.modelo.Ventas;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private Cliente cliente;
    private List<ItemVenta> itemVentaList;

    public CarritoCompra(Cliente cliente) {
        this.cliente = cliente;
        this.itemVentaList = new ArrayList<>();
    }

    public List<ItemVenta> getItemVentaList() {
        return itemVentaList;
    }

    public void agregarItem(ItemVenta item) {
        System.out.println("Agregando item al carrito: " + item.getProducto().getNombre() + " - Cantidad: " + item.getCantidad());
        itemVentaList.add(item);
    }

    public void eliminarItem(ItemVenta item) {
        itemVentaList.remove(item);
    }

    public void vaciarCarrito() {
        itemVentaList.clear();
        System.out.println("Carrito vaciado exitosamente.");
    }

    public void procesarProductos() {

        boolean contador = true;
        System.out.println("Procesando productos en el carrito:");

        while (contador) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = System.console().readLine();

            Producto productoSelect = Inventario.buscarProductoPorNombre(nombreProducto);

            System.out.print("Ingrese la cantidad del producto: ");
            int cantidadProducto = Integer.parseInt(System.console().readLine());

            Inventario.verificarDisponibilidad(productoSelect.getNombre(), cantidadProducto);

            agregarItem(new ItemVenta(productoSelect, cantidadProducto));

            System.out.println("¿Desea agregar otro producto? (si/no)");
            String respuesta = System.console().readLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                contador = false;
                System.out.println("Finalizando el proceso de productos en el carrito.");
            }
        }
    }
}
