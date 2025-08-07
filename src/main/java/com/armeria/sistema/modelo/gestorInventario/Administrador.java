package com.armeria.sistema.modelo.gestorInventario;

public class Administrador {

    public static void main(String[] args) {
        GestorArma gestorArmas = new GestorArma();
        GestorMunicion gestorMunicion = new GestorMunicion();
        GestorAccesorio gestorAccesorio = new GestorAccesorio();

        // AGREGAMOS ARMAS


//        gestorArmas.registrarProducto(pistola);
//        gestorArmas.registrarProducto(escopeta);
        gestorArmas.mostrarInventario();

        // AGREGAMOS MUNICIONES


//        gestorMunicion.registrarProducto(municionPistola);
//        gestorMunicion.registrarProducto(municionEscopeta);
        gestorMunicion.mostrarInventario();


        // AGREGAMOS ACCESORIOS


//        gestorAccesorio.registrarProducto(accesorioPistola);
//        gestorAccesorio.registrarProducto(accesorioEscopeta);
        gestorAccesorio.mostrarInventario();

    }
}
