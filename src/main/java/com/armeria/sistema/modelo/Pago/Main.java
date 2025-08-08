package com.armeria.sistema.modelo.Pago;

import com.armeria.sistema.modelo.Ventas.Cliente;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Pago iniciado.");
        // Ejemplo de uso
        PagoService pagoService = new PagoService();
        pagoService.selectMetodo();
        Cliente cliente = new Cliente("12345678", "Juan", "Perez", true);
        Pago pago = new Pago( cliente, 200);
        pagoService.pagar(pago);
    }
}