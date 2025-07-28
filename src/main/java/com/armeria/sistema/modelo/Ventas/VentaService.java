package com.armeria.sistema.modelo.Ventas;
import java.util.List;
public class VentaService {

    public static void main(String[] args) {

        // Crear un cliente
        Cliente cliente = new Cliente("12345678", "Juan", "Pérez", true);

        // Crear producto
        Producto producto1 = new Producto("Pistola Glock 17", "Arma", 500.0, 10, "ABC123XYZ");
        Producto producto2 = new Producto("Munición 9mm", "Municion", 20.0, 100);
        Producto producto3 = new Producto("Escopeta AR-15", "Arma", 1200.0, 5, "RIF123XYZ");
        Producto producto4 = new Producto("Munición .223 Remington", "Municion", 30.0, 50);
        Producto producto5 = new Producto("Accesorio Mira Telescópica", "Accesorio", 150.0, 20);

        // Crear un item de venta
        ItemVenta itemVenta = new ItemVenta(producto1, 2);

        // Crear una estrategia de venta
        ProcesadorVenta estrategiaVentaMunicion = new ProcesadorVenta(new VentaMunicion());
        ProcesadorVenta estrategiaVentaArma = new ProcesadorVenta(new VentaArma());
        ProcesadorVenta estrategiaVentaAccesorio = new ProcesadorVenta(new VentaAccesorio());


        // Procesar la venta

    }

}
