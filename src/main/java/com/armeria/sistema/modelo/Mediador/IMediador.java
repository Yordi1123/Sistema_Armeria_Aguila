package com.armeria.sistema.modelo.Mediador;

public interface IMediador {
    public void enviar(Mensaje mensaje, Servicio emisor);
}
