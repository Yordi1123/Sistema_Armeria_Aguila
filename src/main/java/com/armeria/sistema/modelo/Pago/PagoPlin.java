package com.armeria.sistema.modelo.Pago;

public class PagoPlin implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido para Blimb");
            return;
        }
        System.out.println("Verificando cuenta Plin...");
        System.out.println("Enviando solicitud de cobro...");
        System.out.println("Pago exitoso por S/ " + monto + " desde Plin");
    }
}
