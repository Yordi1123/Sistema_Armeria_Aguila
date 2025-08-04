package com.armeria.sistema.modelo.Pago;

public class ServicioPago {

    private MetodoPago metodo;

    public void setMetodoPago(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public void pagar(double monto) {
        if (metodo != null) {
            metodo.procesarPago(monto);
        } else {
            System.out.println("No se ha seleccionado un método de pago");
        }
    }
}
