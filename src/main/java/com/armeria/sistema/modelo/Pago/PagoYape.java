package com.armeria.sistema.modelo.Pago;

public class PagoYape implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido para Yape");
            return;
        }
        System.out.println("Abre Yape y escanea el código QR");
        System.out.println("Esperando confirmación...");
        System.out.println("Pago recibido por S/ " + monto + " vía Yape");
    }
}
