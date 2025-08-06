package com.armeria.sistema.modelo.Pago;

public class PagoEfectivo implements MetodoPago {

    @Override
    public void procesarPago(Pago pago) {
        if (pago.getMonto() <= 0) {
            System.out.println("Monto inválido para pago en efectivo");
            return;
        }
        pago.setMetodo(MetodoPagoEnum.EFECTIVO);
        System.out.println("Cliente paga en efectivo S/ " + pago.getMonto());
        System.out.println("Caja: Entregar comprobante y registrar pago");
    }
}
