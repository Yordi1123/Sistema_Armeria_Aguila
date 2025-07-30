package com.armeria.sistema.modelo.Ventas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Pago {
    private Cliente cliente;
    private MetodoPagoEnum metodoPago; // Ejemplo: "Tarjeta de Crédito", "Efectivo", etc.
    private double monto;
    private LocalDateTime fechaPago;

    public Pago(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
    // Metodo para procesar el pago
    public boolean procesarPago() {

        // Lógica para procesar el pago
        seleccionarMedioPago();
        System.out.println("Procesando pago de " + monto + " con método " + metodoPago);

        // Simulación de procesamiento de pago
        if (monto > 0) {
            System.out.println("Pago procesado exitosamente.");
            setFechaPago(LocalDateTime.now());
            return true;
        } else {
            System.out.println("Error: Monto de pago inválido.");}
            return false;
    }

    // Metodo para seleccionar el metodo de pago
    public void seleccionarMedioPago() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, MetodoPagoEnum> opciones = Map.of(
                1, MetodoPagoEnum.TARJETA_CREDITO,
                2, MetodoPagoEnum.TARJETA_DEBITO,
                3, MetodoPagoEnum.EFECTIVO,
                4, MetodoPagoEnum.TRANSFERENCIA_BANCARIA,
                5, MetodoPagoEnum.YAPE,
                6, MetodoPagoEnum.BLIMP
        );

        while (true) {
            System.out.println("Seleccione medio de pago:");
            System.out.println("1. Tarjeta de Crédito");
            System.out.println("2. Tarjeta de Débito");
            System.out.println("3. Efectivo");
            System.out.println("4. Transferencia Bancaria");
            System.out.println("5. Yape");
            System.out.println("6. Blimp");
            System.out.println("==============================================");
            System.out.print("Ingrese el número de opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());

                if (opciones.containsKey(opcion)) {
                    this.metodoPago = opciones.get(opcion);
                    System.out.println("Método de pago seleccionado: " + this.metodoPago);
                    break;
                } else {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
            }
        }
    }

    // Métodos Getter y Setter
    public MetodoPagoEnum getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoEnum metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
