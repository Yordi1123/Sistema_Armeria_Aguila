package com.armeria.sistema.modelo.Fachada;

public class Usuario {
    public static void main(String[] args) {
        Fachada fachada = new Fachada();
        fachada.iniciarSistema();
        fachada.mostrarInventario();
        fachada.iniciarProcesoVenta();
        fachada.mostrarInventario();
    }
}