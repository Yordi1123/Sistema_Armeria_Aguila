package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.Mediador.Mediador;
import com.armeria.sistema.modelo.Mediador.Mensaje;
import com.armeria.sistema.modelo.Mediador.ServicioPago;
import com.armeria.sistema.modelo.Mediador.ServicioVenta;

public class VentaService {

    public static void main(String[] args) {

        // Crear producto
        Producto producto1 = new Producto("Pistola Glock 17", TipoProducto.ARMA, 500.0, 10, "ABC123XYZ");
        Producto producto2 = new Producto("Municion 9mm", TipoProducto.MUNICION, 20.0, 1000);
        Producto producto3 = new Producto("Escopeta AR-15", TipoProducto.ARMA, 1200.0, 5, "RIF123XYZ");
        Producto producto4 = new Producto("Municion .223 Remington", TipoProducto.MUNICION, 30.0, 500);
        Producto producto5 = new Producto("Accesorio Mira Telescopica", TipoProducto.ACCESORIO, 150.0, 20);
        Producto producto6 = new Producto("Arnes de Seguridad", TipoProducto.ACCESORIO, 75.0, 15);
        Producto producto7 = new Producto("Botiquin PA", TipoProducto.ACCESORIO, 50.0, 30);
        Producto producto8 = new Producto("Cargador Extra Glock 17", TipoProducto.ACCESORIO, 25.0, 25);
        Producto producto9 = new Producto("Cargador Extra AR-15", TipoProducto.ACCESORIO, 40.0, 10);
        Producto producto10 = new Producto("Linterna tactica", TipoProducto.ACCESORIO, 60.0, 40);
        Producto producto11 = new Producto("Guantes de Proteccion", TipoProducto.ACCESORIO, 15.0, 50);
        Producto producto12 = new Producto("Gafas de Seguridad", TipoProducto.ACCESORIO, 20.0, 35);
        Producto producto13 = new Producto("Kit de limpieza de armas", TipoProducto.ACCESORIO, 35.0, 20);
        Producto producto14 = new Producto("Chaqueta Tactica", TipoProducto.ACCESORIO, 80.0, 10);
        Producto producto15 = new Producto("Botas Tacticas", TipoProducto.ACCESORIO, 100.0, 15);
        Producto producto16 = new Producto("Cinturon Tactico", TipoProducto.ACCESORIO, 30.0, 25);
        Producto producto17 = new Producto("Funda de Pistola", TipoProducto.ACCESORIO, 45.0, 30);
        Producto producto18 = new Producto("Funda de Escopeta", TipoProducto.ACCESORIO, 55.0, 20);
        Producto producto19 = new Producto("Cargador de Municion 9mm", TipoProducto.ACCESORIO, 10.0, 100);
        Producto producto20 = new Producto("Cargador de Municion .223", TipoProducto.ACCESORIO, 15.0, 50);


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

        // Crear al objeto centralizador de la comunicacion
        Mediador mediador = new Mediador();

        // Mostrar el inventario
        Inventario.mostrarInventario();

        // Objetos que participan en la comunicacion
        ServicioVenta servicioVenta = new ServicioVenta(mediador);
        ServicioPago servicioPago = new ServicioPago(mediador);


        // Agregarlos al objeto centralizador
        mediador.agregarServicio(servicioVenta);
        mediador.agregarServicio(servicioPago);

        Venta venta1 = new Venta();
        venta1.solicitarDatosCliente();
        venta1.registrarProductos();
        venta1.verificarCompra();

        // Creando insumos para el mensaje a ServicioPago
        Cliente cliente1 = venta1.getCliente();
        double monto = venta1.calcularTotalVenta();
        String solicitud = "Solicitando procesar pago";
        Mensaje mensajeVenta = new Mensaje(cliente1,monto,solicitud);

        // Enviar mensaje a Servicio Pago
        servicioVenta.comunicar(mensajeVenta);


        String respuesta = "Pago procesado";
        servicioPago.comunicar(new Mensaje(true,respuesta));






        System.out.println("Inventario actualizado después de la venta:");
        Inventario.mostrarInventario();


    }

}
