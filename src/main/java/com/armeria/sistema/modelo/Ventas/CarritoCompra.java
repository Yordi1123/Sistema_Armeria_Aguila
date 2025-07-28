package com.armeria.sistema.modelo.Ventas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    // Metodo para procesar productos en el carrito
    // Permite al usuario ingresar productos y cantidades, verifica disponibilidad y agrega al carrito
    public void procesarProductos() {

        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;

        System.out.println("Procesar productos en el carrito de compra.");

        while (seguir) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim();

            // Validar entrada
            if (nombreProducto.isEmpty()) {
                System.out.println("El nombre del producto no puede estar vacío.");
                continue;
            }

            Producto productoSelect = Inventario.buscarProductoPorNombre(nombreProducto);

            if (productoSelect == null) {
                System.out.println("El producto '" + nombreProducto + "' no fue encontrado en el inventario.");
                continue;
            }

            System.out.print("Ingrese la cantidad del producto: ");
            int cantidadProducto;
            try {
                cantidadProducto = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Ingrese un número entero.");
                continue;
            }

            if (cantidadProducto <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
                continue;
            }

            boolean disponible = Inventario.verificarDisponibilidad(productoSelect.getNombre(), cantidadProducto);

            if (!disponible) {
                System.out.println("No se puede agregar el producto al carrito.");
                continue;
            }

            // Agregar al carrito
            agregarItem(new ItemVenta(productoSelect, cantidadProducto));
            System.out.println("Producto agregado al carrito.");

            System.out.print("¿Desea agregar otro producto? (si/no): ");
            String respuesta = scanner.nextLine().trim();

            if (!respuesta.equalsIgnoreCase("si")) {
                seguir = false;
                System.out.println("Finalizando el proceso de productos en el carrito.");
            }
        }
    }
}
