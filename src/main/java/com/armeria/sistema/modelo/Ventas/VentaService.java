package com.armeria.sistema.modelo.Ventas;
import java.util.List;
public class VentaService {

    public static void main(String[] args) {

        // Crear producto
        Producto producto1 = new Producto("Pistola Glock 17", "Arma", 500.0, 10, "ABC123XYZ");
        Producto producto2 = new Producto("Municion 9mm", "Municion", 20.0, 100);
        Producto producto3 = new Producto("Escopeta AR-15", "Arma", 1200.0, 5, "RIF123XYZ");
        Producto producto4 = new Producto("Municion .223 Remington", "Municion", 30.0, 50);
        Producto producto5 = new Producto("Accesorio Mira Telescopica", "Accesorio", 150.0, 20);
        Producto producto6 = new Producto("Arnes de Seguridad", "Accesorio", 75.0, 15);
        Producto producto7 = new Producto("Botiquin PA", "Accesorio", 50.0, 30);
        Producto producto8 = new Producto("Cargador Extra Glock 17", "Accesorio", 25.0, 25);
        Producto producto9 = new Producto("Cargador Extra AR-15", "Accesorio", 40.0, 10);
        Producto producto10 = new Producto("Linterna tactica", "Accesorio", 60.0, 40);
        Producto producto11 = new Producto("Guantes de Proteccion", "Accesorio", 15.0, 50);
        Producto producto12 = new Producto("Gafas de Seguridad", "Accesorio", 20.0, 35);
        Producto producto13 = new Producto("Kit de limpieza de armas", "Accesorio", 35.0, 20);
        Producto producto14 = new Producto("Funda de pistola", "Accesorio", 45.0, 15);
        Producto producto15 = new Producto("Funda de escopeta", "Accesorio", 55.0, 10);
        Producto producto16 = new Producto("Cargador de municion 9mm", "Accesorio", 10.0, 100);
        Producto producto17 = new Producto("Cargador de municion .223 R", "Accesorio", 15.0, 50);
        Producto producto18 = new Producto("Cargador de municion 12GA", "Accesorio", 20.0, 30);
        Producto producto19 = new Producto("Cargador de municion 20GA", "Accesorio", 25.0, 20);
        Producto producto20 = new Producto("Cargador de municion 9x18mm", "Accesorio", 12.0, 40);

        // Agregar productos al inventario
        Inventario.agregarProducto(producto1);
        Inventario.agregarProducto(producto2);
        Inventario.agregarProducto(producto3);
        Inventario.agregarProducto(producto4);
        Inventario.agregarProducto(producto5);
        Inventario.agregarProducto(producto6);
        Inventario.agregarProducto(producto7);
        Inventario.agregarProducto(producto8);
        Inventario.agregarProducto(producto9);
        Inventario.agregarProducto(producto10);
        Inventario.agregarProducto(producto11);
        Inventario.agregarProducto(producto12);
        Inventario.agregarProducto(producto13);
        Inventario.agregarProducto(producto14);
        Inventario.agregarProducto(producto15);
        Inventario.agregarProducto(producto16);
        Inventario.agregarProducto(producto17);
        Inventario.agregarProducto(producto18);
        Inventario.agregarProducto(producto19);
        Inventario.agregarProducto(producto20);

        // Mostrar el inventario
        Inventario.mostrarInventario();

        // Crear un cliente
        //Cliente cliente = new Cliente("12345678", "Juan", "Pérez", true);

        // Crear una estrategia de venta
        ProcesadorVenta estrategiaVentaArma = new ProcesadorVenta(new VentaArma());
        Cliente cliente = estrategiaVentaArma.solicitarDatosCliente();
        estrategiaVentaArma.procesarVenta(cliente);
        //ProcesadorVenta estrategiaVentaArma = new ProcesadorVenta(new VentaArma());
        //ProcesadorVenta estrategiaVentaAccesorio = new ProcesadorVenta(new VentaAccesorio());

        System.out.println("Inventario actualizado después de la venta:");
        Inventario.mostrarInventario();


    }

}
