package com.armeria.sistema.modelo.Mediador;

public abstract class Servicio {
    protected IMediador mediador;

    public IMediador getMediador() {
        return mediador;
    }

    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }

    public void comunicar(Mensaje mensaje){
        this.getMediador().enviar(mensaje, this);
    }

    public abstract void recibir(Mensaje mensaje);
}
