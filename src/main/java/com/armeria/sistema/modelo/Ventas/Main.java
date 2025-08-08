package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.gestorInventario.InventarioService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Ventas iniciado.");

        // Ejemplo de uso (funcionamiento básico para demotracion de la cadena de responsabilidad)
        InventarioService inventarioService = new InventarioService();
        inventarioService.cargarInventario();
        inventarioService.mostrarCatalogo();

        VentaService ventaService = new VentaService();
        ventaService.iniciarProcesoVenta();

    }
}
