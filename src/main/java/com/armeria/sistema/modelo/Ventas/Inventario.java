package com.armeria.sistema.modelo.Ventas;
import java.util.ArrayList;
import java.util.List;
// Clase que representa el inventario de productos disponibles para la venta (Se extiende al gestor de inventario)
public class Inventario {
    private static final List<Producto> PRODUCTO_LIST = new ArrayList<>();

    public Inventario() {
        // Crear producto
        Producto producto1 = new Producto("Pistola Glock 17", "Arma", 500.0, 10, "ABC123XYZ");
        Producto producto2 = new Producto("Munición 9mm", "Municion", 20.0, 100);
        Producto producto3 = new Producto("Escopeta AR-15", "Arma", 1200.0, 5, "RIF123XYZ");
        Producto producto4 = new Producto("Munición .223 Remington", "Municion", 30.0, 50);
        Producto producto5 = new Producto("Accesorio Mira Telescópica", "Accesorio", 150.0, 20);
        Producto producto6 = new Producto("Arnés de Seguridad", "Accesorio", 75.0, 15);
        Producto producto7 = new Producto("Botiquín de Primeros Auxilios", "Accesorio", 50.0, 30);
        Producto producto8 = new Producto("Cargador Extra Glock 17", "Accesorio", 25.0, 25);
        Producto producto9 = new Producto("Cargador Extra AR-15", "Accesorio", 40.0, 10);
        Producto producto10 = new Producto("Linterna táctica", "Accesorio", 60.0, 40);
        Producto producto11 = new Producto("Guantes de Protección", "Accesorio", 15.0, 50);
        Producto producto12 = new Producto("Gafas de Seguridad", "Accesorio", 20.0, 35);
        Producto producto13 = new Producto("Kit de limpieza de armas", "Accesorio", 35.0, 20);
        Producto producto14 = new Producto("Funda de transporte para pistola", "Accesorio", 45.0, 15);
        Producto producto15 = new Producto("Funda de transporte para escopeta", "Accesorio", 55.0, 10);
        Producto producto16 = new Producto("Cargador de munición 9mm", "Accesorio", 10.0, 100);
        Producto producto17 = new Producto("Cargador de munición .223 Remington", "Accesorio", 15.0, 50);
        Producto producto18 = new Producto("Cargador de munición 12GA", "Accesorio", 20.0, 30);
        Producto producto19 = new Producto("Cargador de munición 20GA", "Accesorio", 25.0, 20);
        Producto producto20 = new Producto("Cargador de munición 9x18mm", "Accesorio", 12.0, 40);

    }

    // Verifica si un producto está disponible en el inventario
    // y si la cantidad solicitada es menor o igual que el stock disponible
    public static boolean verificarDisponibilidad(String nombreProducto, int cantidad) {
        for (Producto prod : PRODUCTO_LIST){
            if (prod.getNombre().equals(nombreProducto) && cantidad<=prod.getStock()){
                System.out.println("Producto disponible");
                return true;
            }
        }
        System.out.println("Producto agotado");
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
        for (Producto prod : PRODUCTO_LIST) {
            if (prod.getNombre().equals(nombre)) {
                return prod;
            }
        }
        return null; // Producto no encontrado
    }

}
