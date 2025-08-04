package com.armeria.sistema.modelo.Pago;

public class Usuario {
    public static void main(String[] args) {

        PagoService servicioPago = new PagoService();

        servicioPago.selectMetodo();
        System.out.println();

    }
}