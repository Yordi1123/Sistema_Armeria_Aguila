package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Pago.PagoService;
import com.armeria.sistema.modelo.Ventas.VentaService;
import com.armeria.sistema.modelo.gestorInventario.InventarioService;

public class Main {

    public static void main (String[] args){

        // Crear al objeto centralizador de la comunicacion
        Mediador mediador = new Mediador();

        // Objetos que participan en la comunicacion
        InventarioService inventarioService = new InventarioService(mediador);
        VentaService servicioVenta = new VentaService(mediador);
        PagoService servicioPago = new PagoService(mediador);

        // Agregarlos al objeto centralizador
        mediador.agregarServicio(servicioVenta);
        mediador.agregarServicio(servicioPago);
        mediador.agregarServicio(inventarioService);

        // Cargar el inventario
        inventarioService.cargarInventario();
        inventarioService.mostrarCatalogo();


        // Iniciar Proceso de Venta
        servicioVenta.iniciarProcesoVenta();

        // Mostrar el inventario
        inventarioService.mostrarCatalogo();
    }
}
