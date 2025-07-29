package com.armeria.sistema.modelo.Pago;

public class PagoTransferencia implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido para transferencia");
            return;
        }
        System.out.println("Cliente transfiere a la cuenta BCP: 191-XXXXXX-00");
        System.out.println("Verificando depósito...");
        System.out.println("Transferencia confirmada. Monto: S/ " + monto);
    }
}
