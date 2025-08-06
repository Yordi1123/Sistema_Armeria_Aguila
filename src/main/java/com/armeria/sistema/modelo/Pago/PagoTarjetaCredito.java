package com.armeria.sistema.modelo.Pago;
public class PagoTarjetaCredito implements MetodoPago {

    @Override
    public void procesarPago(Pago pago) {
        if (pago.getMonto() <= 0) {
            System.out.println("Monto inválido. El pago no puede procesarse");
            return;
        }
        pago.setMetodo(MetodoPagoEnum.TARJETA_CREDITO);
        System.out.println("---- Pago con Tarjeta de Crédito ----");
        System.out.println("Procesando pago...");
        System.out.println("Pago realizado por S/ " + pago.getMonto() + " con tarjeta de crédito");
    }
}
