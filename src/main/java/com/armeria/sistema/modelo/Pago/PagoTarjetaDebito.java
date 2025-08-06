package com.armeria.sistema.modelo.Pago;

public class PagoTarjetaDebito implements MetodoPago {

    @Override
    public void procesarPago(Pago pago) {
        if (pago.getMonto() <= 0) {
            System.out.println("Monto inválido para tarjeta de débito");
            return;
        }
        pago.setMetodo(MetodoPagoEnum.TARJETA_DEBITO);
        System.out.println("Inserta tu tarjeta de débito y confirma con tu PIN");
        System.out.println("Procesando pago...");
        System.out.println("Pago realizado por S/ " + pago.getMonto() + " con tarjeta de débito");
    }
}
