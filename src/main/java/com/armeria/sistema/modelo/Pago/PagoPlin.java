package com.armeria.sistema.modelo.Pago;

public class PagoPlin implements MetodoPago {

    @Override
    public void procesarPago(Pago pago) {
        if (pago.getMonto() <= 0) {
            System.out.println("Monto inválido para Blimb");
            return;
        }
        pago.setMetodo(MetodoPagoEnum.PLIN);
        System.out.println("Verificando cuenta Plin...");
        System.out.println("Enviando solicitud de cobro...");
        System.out.println("Pago exitoso por S/ " + pago.getMonto() + " desde Plin");
    }
}
