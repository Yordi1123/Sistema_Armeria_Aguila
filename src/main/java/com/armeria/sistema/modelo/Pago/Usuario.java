package com.armeria.sistema.modelo.Pago;
import java.util.Scanner;

public class Usuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioPago servicioPago = new ServicioPago();

        System.out.println("=== Sistema de Pago - Armería ===");
        System.out.println("Métodos disponibles:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Tarjeta de Débito");
        System.out.println("3. Efectivo");
        System.out.println("4. Transferencia Bancaria");
        System.out.println("5. Yape");
        System.out.println("6. Plin");

        System.out.print("Seleccione el método de pago (1-6): ");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese el monto a pagar: S/ ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                servicioPago.setMetodoPago(new PagoTarjetaCredito());
                break;
            case 2:
                servicioPago.setMetodoPago(new PagoTarjetaDebito());
                break;
            case 3:
                servicioPago.setMetodoPago(new PagoEfectivo());
                break;
            case 4:
                servicioPago.setMetodoPago(new PagoTransferencia());
                break;
            case 5:
                servicioPago.setMetodoPago(new PagoYape());
                break;
            case 6:
                servicioPago.setMetodoPago(new PagoPlin());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println();
        servicioPago.pagar(monto);
    }
}