package com.armeria.sistema.modelo.Pago;

public class PagoEfectivo implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido para pago en efectivo");
            return;
        }
        System.out.println("Cliente paga en efectivo S/ " + monto);
        System.out.println("Caja: Entregar comprobante y registrar pago");
    }
}
