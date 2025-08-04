package com.armeria.sistema.modelo.Mediador;

import java.util.ArrayList;
import java.util.List;

public class Mediador implements IMediador {
    private List<Servicio> servicios;

    public Mediador() {
        this.servicios = new ArrayList<>();
    }

    public void agregarServicio(Servicio servicio){
        this.servicios.add(servicio);
    }

    @Override
    public void enviar(Mensaje mensaje, Servicio emisor) {
        for (Servicio serv : servicios) {
            if (serv != emisor) {
                serv.recibir(mensaje);
            }
        }
    }
}
