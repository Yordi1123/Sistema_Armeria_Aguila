package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.Pago.Pago;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Venta {
    private Cliente cliente;
    private CarritoCompra carrito;
    private Comprobante comprobante;
    private final double IGV = 0.18; // Se puede ajustar este valor según la necesidad
    private double totalConIgv;


    public Venta() {
    }

    // Metodo para solicitar los datos del cliente
    public void solicitarDatosCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Registro de Cliente =====");

        // Solicitar y validar DNI
        String dni;
        do {
            System.out.print("Ingrese DNI del cliente (8 dígitos): ");
            dni = scanner.nextLine().trim();
            if (!dni.matches("\\d{8}")) {
                System.out.println("DNI inválido. Debe contener exactamente 8 dígitos numéricos.");
            }
        } while (!dni.matches("\\d{8}"));

        // Solicitar nombre
        String nombre;
        do {
            System.out.print("Ingrese nombre del cliente: ");
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());

        // Solicitar apellido
        String apellido;
        do {
            System.out.print("Ingrese apellido del cliente: ");
            apellido = scanner.nextLine().trim();
            if (apellido.isEmpty()) {
                System.out.println("El apellido no puede estar vacío.");
            }
        } while (apellido.isEmpty());

        // Solicitar fecha de nacimiento y validar mayoría de edad
        LocalDate fechaNacimiento = null;
        while (true) {
            System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
            String fechaInput = scanner.nextLine().trim();
            try {
                fechaNacimiento = LocalDate.parse(fechaInput);
                int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

                if (edad > 85 || edad < 18) {
                    System.out.println("Edad del cliente fuera del rango (18-85). Edad actual: " + edad + " años.");
                    return; // Detener el registro
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Use el formato YYYY-MM-DD.");
            }
        }

        // Solicitar si tiene licencia
        boolean tieneLicencia;

        TipoLicencia tipoLicencia = null;

        while (true) {
            System.out.print("¿El cliente tiene licencia para comprar armas? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("si")) {
                System.out.println("Ingrese el tipo de licencia (L1, L2, L3, L4, L5, L6): ");
                switch (scanner.nextLine().trim().toUpperCase()) {
                    case "L1": tipoLicencia = TipoLicencia.L1_DEFENSA_PERSONAL; break;
                    case "L2": tipoLicencia = TipoLicencia.L2_SEGURIDA_DPRIVADA; break;
                    case "L3": tipoLicencia = TipoLicencia.L3_CAZA_DEPORTIVA; break;
                    case "L4": tipoLicencia = TipoLicencia.L4_TIRO_DEPORTIVO; break;
                    case "L5": tipoLicencia = TipoLicencia.L5_COLECCION; break;
                    case "L6": tipoLicencia = TipoLicencia.L6_INSTIUCIONAL;
                        break;
                    default:
                        System.out.println("Tipo de licencia inválido. Debe ser L1, L2, L3, L4, L5 o L6.");
                        continue; // Volver a solicitar la licencia
                }

                tieneLicencia = true;
                break;
            } else if (respuesta.equals("n") || respuesta.equals("no")) {
                tieneLicencia = false;
                break;
            } else {
                System.out.println("Respuesta no válida. Escriba 's' para sí o 'n' para no.");
            }
        }

        // Crear cliente y carrito
        this.cliente = new Cliente(dni, nombre, apellido, tieneLicencia);
        this.cliente.setTipoLicencia(tipoLicencia);
        this.cliente.setFechaNacimiento(fechaNacimiento);
        this.carrito = new CarritoCompra(cliente);

        System.out.println("Cliente registrado correctamente.");
    }


    // Registrar producto en el carrito de compras
    public void registrarProductos() {
        if (cliente == null){return;}
        carrito.procesarProductos(); // Salida (conexion con carrito)
    }


    public double calcularTotalVenta() {

        double total = 0;
        for (ItemVenta item : carrito.getItemVentaList()) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void mostrarVentaDetalles() {
        double subtotal = calcularTotalVenta();
        double igvCalculado = subtotal * IGV;
        this.totalConIgv = subtotal + igvCalculado;

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             DETALLES DE LA VENTA                 ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        System.out.printf("Cliente         : %s %s%n", cliente.getNombre(), cliente.getApellido());
        System.out.printf("DNI             : %s%n", cliente.getDni());
        System.out.printf("Licencia        : %s%n", cliente.isTieneLicencia() ? cliente.getTipoLicencia() : "No tiene");

        System.out.println("\n════════════════════════════════════════════════════");
        System.out.println("Productos en el carrito:");
        System.out.println("────────────────────────────────────────────────────");
        System.out.printf("| %-20s | %-8s | %-11s |%n", "Producto", "Cantidad", "Subtotal");
        System.out.println("────────────────────────────────────────────────────");

        for (ItemVenta item : carrito.getItemVentaList()) {
            System.out.printf("| %-20s | %-8d | S/ %-8.2f |%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
        }

        System.out.println("────────────────────────────────────────────────────");
        System.out.printf("| %-31s | S/ %-8.2f |%n", "SUBTOTAL", subtotal);
        System.out.printf("| %-31s | S/ %-8.2f |%n", "IGV (18%)", igvCalculado);
        System.out.printf("| %-31s | S/ %-8.2f |%n", "TOTAL CON IGV", totalConIgv);
        System.out.println("════════════════════════════════════════════════════\n");
    }


    // Verificar la compra antes de procesar el pago
    public boolean verificarCompra(){
        if (cliente == null){return true;}

        System.out.println("Verificando venta...");
        mostrarVentaDetalles();

        System.out.println("1. Continuar con el pago");
        System.out.println("2. Modificar carrito");
        System.out.println("3. Cancelar venta");
        System.out.print("Seleccione una opción: ");

        int opcion = new Scanner(System.in).nextInt();
        switch (opcion) {
            case 1:

                ///////////////////////////////////////////////
                System.out.println("Continuando con el pago...");
                //registrarPago(); // Salida (conexion con modulo de pago)
                return true; // Continuar con el pago
                //break;
                ///////////////////////////////////////////////

            case 2:
                System.out.println("Modificando carrito...");
                registrarProductos();
                return verificarCompra(); // Volver a verificar la compra
            case 3:
                System.out.println("Venta cancelada.");
                return false;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                return verificarCompra(); // Volver a verificar la compra
        }
        // Si se llega aquí, significa que la compra es válida
        //return true;
    }

    // Procesar el pago del cliente
    public void registrarPago(Pago pago) {

        if (!pago.isValido()) {
            System.out.println("No se realizo el pago.");
            return;
        }
        actualizarInventario();
        this.comprobante = new Comprobante(pago, carrito);
        comprobante.generarComprobante();
        guardarVenta(comprobante);
    }

    // Actualizar el inventario después de procesar la venta
    public void actualizarInventario() {
        Inventario.actualizarStockGeneral(carrito);
        System.out.println("Venta procesada exitosamente. Gracias por su compra, " + cliente.getNombre() + ".");
    }

    public void guardarVenta(Comprobante comprobante) {
        // Aquí podrías implementar la lógica para guardar la venta en una base de datos o archivo
        RegistroVentas.registrarVenta(comprobante);
        System.out.println("Venta guardada exitosamente.");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalConIgv() {
        return totalConIgv;
    }
}
