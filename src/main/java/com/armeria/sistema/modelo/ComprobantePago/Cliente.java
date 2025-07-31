package com.armeria.sistema.modelo.ComprobantePago;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente {

    private static final String RUC_EMPRESA = "20445412628";
    private static final String DIRECCION_EMPRESA = "Jr. Elias Aguirre 238 Of. 204";
    private static final String NOMBRE_VENDEDOR = "Luis Gonzales";
    private static final String DNI_VENDEDOR = "12345678";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== SISTEMA DE COMPROBANTES =====");
        System.out.println("Nombre del vendedor: " + NOMBRE_VENDEDOR);
        System.out.println("DNI del vendedor: " + DNI_VENDEDOR);
        System.out.println("RUC Empresa: " + RUC_EMPRESA);
        System.out.println("Dirección Empresa: " + DIRECCION_EMPRESA);

        System.out.print("Nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        System.out.print("DNI o RUC del cliente: ");
        String docCliente = sc.nextLine();

        System.out.print("Dirección del cliente: ");
        String direccionCliente = sc.nextLine();

        System.out.print("Nombre del arma: ");
        String nombreArma = sc.nextLine();

        System.out.print("Descripción del bien: ");
        String descripcion = sc.nextLine();

        System.out.print("Monto total (S/): ");
        double monto = Double.parseDouble(sc.nextLine());

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Generar Boleta");
            System.out.println("2. Generar Factura");
            System.out.println("3. Documento de Traslado de Arma");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("1. Boleta Física");
                    System.out.println("2. Boleta Electrónica");
                    System.out.print("Elija tipo de boleta: ");
                    int tipoBoleta = Integer.parseInt(sc.nextLine());

                    Boleta boleta;
                    if (tipoBoleta == 1) {
                        System.out.print("Ingrese oficina de emisión: ");
                        String oficina = sc.nextLine();
                        boleta = new BoletaFisica("B001", NOMBRE_VENDEDOR, DNI_VENDEDOR, DIRECCION_EMPRESA,
                                nombreCliente, docCliente, LocalDate.now(), monto, oficina);
                    } else {
                        boleta = new BoletaElectronica("B002", NOMBRE_VENDEDOR, DNI_VENDEDOR, DIRECCION_EMPRESA,
                                nombreCliente, docCliente, LocalDate.now(), monto,
                                "SEC123", "QR987", "SUNAT789");
                    }

                    boleta.generarBoleta();
                    break;

                case 2:
                    System.out.println("1. Factura Física");
                    System.out.println("2. Factura Electrónica");
                    System.out.print("Elija tipo de factura: ");
                    int tipoFactura = Integer.parseInt(sc.nextLine());

                    Factura factura;
                    if (tipoFactura == 1) {
                        System.out.print("Ingrese oficina de emisión: ");
                        String oficina = sc.nextLine();
                        factura = new FacturaFisica("F001", RUC_EMPRESA, NOMBRE_VENDEDOR, DIRECCION_EMPRESA,
                                docCliente, nombreCliente, LocalDate.now(), monto, oficina);
                    } else {
                        factura = new FacturaElectronica("F002", RUC_EMPRESA, NOMBRE_VENDEDOR, DIRECCION_EMPRESA,
                                docCliente, nombreCliente, LocalDate.now(), monto, "SUNAC999");
                    }

                    factura.generarFactura();
                    break;

                case 3:
                    System.out.println("1. Documento Físico");
                    System.out.println("2. Documento Electrónico");
                    System.out.print("Elija tipo de documento de traslado: ");
                    int tipoDoc = Integer.parseInt(sc.nextLine());

                    DocumentoTrasladoBienesArmas doc;
                    if (tipoDoc == 1) {
                        System.out.print("Ingrese oficina de emisión: ");
                        String oficina = sc.nextLine();
                        doc = new DocumentoFisico(NOMBRE_VENDEDOR, RUC_EMPRESA, DIRECCION_EMPRESA,
                                nombreCliente, docCliente, direccionCliente, LocalDate.now(),
                                descripcion, monto, nombreArma, oficina);
                    } else {
                        doc = new DocumentoElectronico(NOMBRE_VENDEDOR, RUC_EMPRESA, DIRECCION_EMPRESA,
                                nombreCliente, docCliente, direccionCliente, LocalDate.now(),
                                descripcion, monto, nombreArma, "SUNAT123", "SUCAMET01");
                    }

                    doc.generarDocumento();
                    mostrarClausulas();
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }

    private static void mostrarClausulas() {
        System.out.println("\n--- CLÁUSULAS DE TRASLADO DE ARMAS ---");
        System.out.println("1. El presente documento ampara el traslado de un arma de fuego de uso civil.");
        System.out.println("2. El arma está registrada y su tenencia está autorizada según ley vigente.");
        System.out.println("3. El traslado deberá realizarse cumpliendo con todas las normas de seguridad.");
        System.out.println("4. Este documento no reemplaza la autorización de porte de arma.");
        System.out.println("5. El documento debe ser mostrado a solicitud de la autoridad competente.");
        System.out.println("--------------------------------------------\n");
    }
}
