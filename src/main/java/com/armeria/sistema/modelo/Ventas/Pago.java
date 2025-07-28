package com.armeria.sistema.modelo.Ventas;

import java.time.LocalDate;

public class Pago {
    private Cliente cliente;
    private  MetodoPagoEnum metodoPago; // Ejemplo: "Tarjeta de Crédito", "Efectivo", etc.
    private double monto;
    private String fechaPago;

    public Pago(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
    // Metodo para procesar el pago
    public boolean procesarPago() {

        // Lógica para procesar el pago
        seleccionarMetodoPago();
        System.out.println("Procesando pago de " + monto + " con método " + metodoPago);

        // Simulación de procesamiento de pago
        if (monto > 0) {
            System.out.println("Pago procesado exitosamente.");
            return true;
        } else {
            System.out.println("Error: Monto de pago inválido.");}
            return false;
    }

    // Metodo para generar un comprobante de pago (esta se extiende al modulo Comprobante de Pago)
    public void generarComprobante(CarritoCompra carritoCompra) {
        // Lógica para generar un comprobante de pago
        System.out.println("Generando comprobante de pago...");
        System.out.println("==============================================");
        System.out.println("Armeria SAC");
        System.out.println("RUC: 12345678901");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("==============================================");
        System.out.println("Detalles de compra:");
        System.out.println("==============================================");
        for (ItemVenta item : carritoCompra.getItemVentaList()) {
            System.out.println("Producto: " + item.getProducto().getNombre() + " | Cantidad: " + item.getCantidad() + " | Precio (u): S/ " + item.getProducto().getPrecioUnitario());
        }
        System.out.println("==============================================");

        System.out.println("Método de Pago: " + metodoPago);
        System.out.println("Monto: " + monto);
        System.out.println("Fecha de Pago: " + LocalDate.now());
        System.out.println("==============================================");
    }

    // Método para seleccionar el método de pago
    public void seleccionarMetodoPago() {
        System.out.println("Selecione medio de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Tarjeta de Débito");
        System.out.println("3. Efectivo");
        System.out.println("4. Transferencia Bancaria");
        System.out.println("5. Yape");
        System.out.println("6. Blimp");
        System.out.println("==============================================");
        int metodoSelect = Integer.parseInt(System.console().readLine());

        switch (metodoSelect) {

            case 1:
                this.metodoPago = MetodoPagoEnum.TARJETA_CREDITO;
            case 2:
                this.metodoPago = MetodoPagoEnum.TARJETA_DEBITO;
            case 3:
                this.metodoPago = MetodoPagoEnum.EFECTIVO;
            case 4:
                this.metodoPago = MetodoPagoEnum.TRANSFERENCIA_BANCARIA;
            case 5:
                this.metodoPago = MetodoPagoEnum.YAPE;
            case 6:
                this.metodoPago = MetodoPagoEnum.BLIMP;

            default:
                System.out.println("Método de pago no válido. Seleccione nuevamente.");
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

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    // Enum para los métodos de pago
    public enum MetodoPagoEnum {
        TARJETA_CREDITO,
        TARJETA_DEBITO,
        EFECTIVO,
        TRANSFERENCIA_BANCARIA,
        YAPE,
        BLIMP;
    }
}
