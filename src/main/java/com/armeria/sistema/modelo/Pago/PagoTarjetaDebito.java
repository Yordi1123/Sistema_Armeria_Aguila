package com.armeria.sistema.modelo.Pago;

public class PagoTarjetaDebito implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido para tarjeta de débito");
            return;
        }
        System.out.println("Inserta tu tarjeta de débito y confirma con tu PIN");
        System.out.println("Procesando pago...");
        System.out.println("Pago realizado por S/ " + monto + " con tarjeta de débito");
    }
}
