package com.armeria.sistema.modelo.Ventas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// Clase que representa el inventario de productos disponibles para la venta (Se extiende al gestor de inventario)
public class Inventario {
    private static final List<Producto> PRODUCTO_LIST = new ArrayList<>();

    public Inventario() {

    }

    // Verifica si un producto está disponible en el inventario
    // y si la cantidad solicitada es menor o igual que el stock disponible
    public static boolean verificarDisponibilidad(String nombreProducto, int cantidad) {
        // Validar nombre del producto
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            System.out.println("Error: El nombre del producto es inválido.");
            return false;
        }

        // Validar cantidad solicitada
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que cero.");
            return false;
        }

        // Normalizar el nombre del producto (sin espacios y en minúsculas)
        String nombreNormalizado = nombreProducto.trim().toLowerCase();

        // Buscar el producto
        for (Producto prod : PRODUCTO_LIST) {
            if (prod.getNombre() != null &&
                    prod.getNombre().trim().toLowerCase().equals(nombreNormalizado)) {

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
        System.out.println("Producto no encontrado en el inventario: " + nombreProducto);
        return false;
    }

    // Actualiza el stock de un producto específico
    public static void actualizarStock(Producto producto, int cantidadVendida) {
        if (verificarDisponibilidad(producto.getNombre(),cantidadVendida)){
            producto.setStock(producto.getStock()-cantidadVendida);
            System.out.println("stock actualizado exitosamente");
        }
    }

    // Actualiza el stock de todos los productos en el carrito de compra
    // al finalizar la compra
    public static void actualizarStockGeneral(CarritoCompra carritoCompra) {
        for (ItemVenta item : carritoCompra.getItemVentaList()) {
            actualizarStock(item.getProducto(), item.getCantidad());
        }
    }

    // Busca un producto por su nombre en el inventario
    public static Producto buscarProductoPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Nombre de producto inválido.");
            return null;
        }

        String nombreNormalizado = nombre.trim().toLowerCase();

        for (Producto prod : PRODUCTO_LIST) {
            if (prod.getNombre() != null &&
                    prod.getNombre().trim().toLowerCase().equals(nombreNormalizado)) {
                return prod;
            }
        }

        return null; // Producto no encontrado
    }

    // Agrega un producto al inventario
    public static void agregarProducto(Producto producto) {
        PRODUCTO_LIST.add(producto);
        //System.out.println("Producto agregado al inventario: " + producto.getNombre());
    }

    // Mostrar todos los productos en el inventario
    public static void mostrarInventario() {
        System.out.println("\n\n========================= INVENTARIO DE PRODUCTOS =========================");
        System.out.printf("%-30s %-20s %-17s %-13s%n", "Nombre", "Tipo", "Precio (S/.)", "Stock");
        System.out.println("----------------------------------------------------------------------------");

        // Ordenar por nombre alfabéticamente
        PRODUCTO_LIST.stream()
                .sorted(Comparator.comparing(Producto::getNombre))
                .forEach(prod -> System.out.printf(
                        "%-30s %-20s %-17s %-13s%n",
                        prod.getNombre(),
                        prod.getTipo(),
                        prod.getPrecioUnitario(),
                        prod.getStock()
                ));

        System.out.println("============================================================================\n\n");
    }

}
