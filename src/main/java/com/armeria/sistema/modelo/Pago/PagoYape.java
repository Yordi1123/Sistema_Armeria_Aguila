package com.armeria.sistema.modelo.Pago;

public class PagoYape implements MetodoPago {

    @Override
    public void procesarPago(Pago pago) {
        if (pago.getMonto() <= 0) {
            System.out.println("Monto inválido para Yape");
            return;
        }
        pago.setMetodo(MetodoPagoEnum.YAPE);
        System.out.println("Abre Yape y escanea el código QR");
        System.out.println("Esperando confirmación...");
        System.out.println("Pago recibido por S/ " + pago.getMonto() + " vía Yape");
    }
}
