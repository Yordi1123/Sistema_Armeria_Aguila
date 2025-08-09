package com.armeria.sistema.modelo.Proxy;

import java.util.Scanner;
import com.armeria.sistema.modelo.Fachada.Fachada;

public class ProxyOperacion implements Operacion {
    private OperacionReal operacionReal;
    private boolean autenticado = false;

    private final String usuarioCorrecto = "admin";
    private final String passwordCorrecto = "1234";

    @Override
    public void ejecutar() {
        if (!autenticado) {
            if (autenticar()) {
                Fachada fachada = new Fachada(); // Creamos la fachada
                operacionReal = new OperacionReal(fachada); // Pasamos la fachada
                operacionReal.ejecutar();
            } else {
                System.out.println("Autenticación fallida. Acceso denegado.");
            }
        } else {
            operacionReal.ejecutar();
        }
    }

    private boolean autenticar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese contraseña: ");
        String password = sc.nextLine();

        if (usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto)) {
            autenticado = true;
            System.out.println("Autenticación exitosa...");
            return true;
        }
        return false;
    }
}
