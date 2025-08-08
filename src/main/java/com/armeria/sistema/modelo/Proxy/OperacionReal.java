package com.armeria.sistema.modelo.Proxy;

public class OperacionReal implements Operacion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando Operación A...");
    }
}