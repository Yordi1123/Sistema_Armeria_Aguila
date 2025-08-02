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

    // Métodos para agregar, eliminar y vaciar el carrito de compra
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
            Producto producto = solicitarProducto(scanner);
            if (producto == null) continue;

            int cantidad = solicitarCantidad(scanner);
            if (cantidad <= 0) continue;

            if (!Inventario.verificarDisponibilidad(producto.getNombre(), cantidad)) {
                System.out.println("No se puede agregar el producto al carrito.");
                continue;
            }

            ItemVenta item = new ItemVenta(producto, cantidad);
            Controlador controlador = crearCadenaControladores();

            if (controlador.registrarProducto(cliente, item, itemVentaList )) {
                System.out.println("El producto se puede agregar al carrito.");
                agregarItem(item);
                System.out.println("Producto agregado al carrito.");
            } else {
                System.out.println("El producto no se puede agregar al carrito.");
            }

            seguir = deseaContinuar(scanner);
        }
        System.out.println("Finalizando el proceso de productos en el carrito.");
    }

// ------------------------- MÉTODOS AUXILIARES -------------------------

    private Producto solicitarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return null;
        }

        Producto producto = Inventario.buscarProductoPorNombre(nombre);

        if (producto == null) {
            System.out.println("El producto '" + nombre + "' no fue encontrado en el inventario.");
        }

        return producto;
    }

    private int solicitarCantidad(Scanner scanner) {
        System.out.print("Ingrese la cantidad del producto: ");
        try {
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
                return -1;
            }
            return cantidad;
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida. Ingrese un número entero.");
            return -1;
        }
    }

    private boolean deseaContinuar(Scanner scanner) {
        System.out.print("¿Desea agregar otro producto? (s/n): ");
        String respuesta = scanner.nextLine().trim();
        return respuesta.equalsIgnoreCase("s");
    }

    private Controlador crearCadenaControladores() {
        Controlador ventaArma = new ControladorArma();
        Controlador ventaMunicion = new ControladorMunicion();
        Controlador ventaAccesorio = new ControladorAccesorio();

        // Configurar la cadena de responsabilidad
        ventaArma.setSiguiente(ventaMunicion);
        ventaMunicion.setSiguiente(ventaAccesorio);

        return ventaArma;
    }

}
