package com.armeria.sistema.modelo.Ventas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Clase que se extiende al modulo de registro de ventas

// Clase para registrar las ventas realizadas en el sistema
public class RegistroVentas {
    private static final List<Comprobante> ventas = new ArrayList<>();

    public static void registrarVenta(Comprobante comprobante) {
        ventas.add(comprobante);
    }

    public static List<Comprobante> obtenerVentas() {
        return new ArrayList<>(ventas);
    }

    public static void limpiarRegistro() {
        ventas.clear();
    }

    public void mostrarRegistro() {
        for (Comprobante comprobante : ventas) {
            System.out.println(comprobante);
        }
    }
}
