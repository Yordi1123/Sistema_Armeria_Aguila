package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Pago.PagoService;

public class ServicioPago extends Servicio{
    private PagoService pagoService = new PagoService();

    public ServicioPago(IMediador mediador) {
        this.setMediador(mediador);
    }

    @Override
    public void recibir(Mensaje mensaje) {
        System.out.println(mensaje.getDescripcion());
        procesarPago(mensaje);
    }

    public void procesarPago(Mensaje mensaje){
        pagoService.selectMetodo();
        pagoService.setCliente(mensaje.getCliente());
        pagoService.setMonto(mensaje.getMonto());
        pagoService.pagar();
    }
}
