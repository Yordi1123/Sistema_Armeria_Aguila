package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Pago.PagoService;
import com.armeria.sistema.modelo.Ventas.Inventario;
import com.armeria.sistema.modelo.Ventas.VentaService;

public class Usuario {

    public static void main (String[] args){

        // Crear al objeto centralizador de la comunicacion
        Mediador mediador = new Mediador();

        // Objetos que participan en la comunicacion
        VentaService servicioVenta = new VentaService(mediador);
        PagoService servicioPago = new PagoService(mediador);

        // Agregarlos al objeto centralizador
        mediador.agregarServicio(servicioVenta);
        mediador.agregarServicio(servicioPago);

        servicioVenta.cargarInventario();
        Inventario.mostrarInventario();
        // Iniciar Proceso de Venta
        servicioVenta.iniciarProcesoVenta();

        // Mostrar el inventario
        Inventario.mostrarInventario();
    }
}
