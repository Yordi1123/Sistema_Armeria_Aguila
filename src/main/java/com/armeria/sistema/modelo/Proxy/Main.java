package com.armeria.sistema.modelo.Proxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Operacion proxy = new ProxyOperacion();
            int opcion;

            do {
                System.out.println("\n==========================================");
                System.out.println("       ARMERÍA EL ÁGUILA S.R.L.        ");
                System.out.println("==========================================");
                System.out.println("|  1. Iniciar Sesión                     |");
                System.out.println("|  2. Salir                              |");
                System.out.println("==========================================");
                System.out.print("  Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println(">>  Nombre de usuario: admin");
                        System.out.println(">>  Contraseña: 1234");
                        proxy.ejecutar();
                        break;
                    case 2:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 2);
        }
    }
}
