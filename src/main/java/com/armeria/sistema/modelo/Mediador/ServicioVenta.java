package com.armeria.sistema.modelo.Mediador;

import com.armeria.sistema.modelo.Ventas.VentaService;

public class ServicioVenta extends Servicio {
    VentaService ventaService;
    public ServicioVenta(IMediador mediador) {
        this.setMediador(mediador);
    }

    @Override
    public void recibir(Mensaje mensaje) {
        System.out.println(mensaje.getDescripcion());
        //logica para recibir la confirmacion de pago de ServicioPago
    }
}
