package com.armeria.sistema.modelo.Ventas;

import com.armeria.sistema.modelo.gestorInventario.ProductoArmeria;
import com.armeria.sistema.modelo.gestorInventario.TipoProducto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ControladorArma extends ControladorBase {
    private static final Map<TipoLicencia, Integer> LIMITE_ARMAS = Map.of(
            TipoLicencia.L1_DEFENSA_PERSONAL, 1,
            TipoLicencia.L2_SEGURIDA_DPRIVADA, 3,
            TipoLicencia.L3_CAZA_DEPORTIVA, 5,
            TipoLicencia.L4_TIRO_DEPORTIVO, 3000
    );

    // Registrar producto tipo arma, verifica si el cliente tiene licencia
    @Override
    public boolean registrarProducto(Cliente cliente, ItemVenta itemventa, List<ItemVenta> listaItemVenta) {

        // Verifica si el producto es de tipo arma
    if (itemventa.getProducto().getTipo().equals(TipoProducto.ARMA) ){
        System.out.println("Procesando producto tipo arma...");
        return validarRegistro(cliente, itemventa, listaItemVenta);
        } else {
            System.out.println("El producto no es un arma.");
        }
        return validarSiguiente(cliente, itemventa, listaItemVenta);
    }

    @Override
    public boolean validarRegistro(Cliente cliente, ItemVenta itemventa, List<ItemVenta> listaItemVenta) {
        ProductoArmeria producto = itemventa.getProducto();

        // 1. Verificar licencia vigente
        if (!cliente.isTieneLicencia()) {
            System.out.println("El cliente no posee una licencia vigente.");
            return false;
        }

        // 2. Validar compatibilidad técnica con el arma registrada al nombre del cliente
        if (!esCompatibleConArmaRegistrada(producto)) {
            System.out.println("El comprador no posee un arma registrada compatible con el arma solicitada.");
            return false;
        }


        // 3. Validar cantidad permitida según tipo de licencia
        if (excedeLimitePermitido(cliente, itemventa,listaItemVenta)) {
            System.out.println("El cliente excede el límite de armas permitidas según su tipo de licencia.");
            return false;
        }

        return true;
    }



    @Override
    public boolean esCompatibleConArmaRegistrada(ProductoArmeria producto) {
        System.out.println("Solicitando compatibilidad técnica del arma (" + producto.getNombre() + ") con el arma registrada.");
        System.out.println("¿El arma es compatible con el tipo y calibre del arma registrada? (s/n)");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        if (respuesta.equals("s") || respuesta.equals("si")) {
            System.out.println("El arma es compatible.");
            return true;
        } else if (respuesta.equals("n") || respuesta.equals("no")) {
            System.out.println("El arma no es compatible.");
            return false;
        } else {
            System.out.println("Respuesta no válida. Escriba 's' para sí o 'n' para no.");
            return esCompatibleConArmaRegistrada(producto); // Volver a solicitar
        }
    }

    @Override
    public boolean excedeLimitePermitido(Cliente cliente, ItemVenta itemventa, List<ItemVenta> listaItemVenta) {

        TipoLicencia tipoLicencia = cliente.getTipoLicencia();
        Integer limiteArmas = LIMITE_ARMAS.get(tipoLicencia);
        ProductoArmeria producto = itemventa.getProducto();


        System.out.printf("Comprando armas con licencia %s. Límite: %d arma(s) %n",
                tipoLicencia, limiteArmas);
        System.out.println("Cantidad solicitada: " + itemventa.getCantidad());



        if (itemventa.getCantidad() + revisarAcumulado(producto, listaItemVenta)> limiteArmas) {
            return true;
        }
        System.out.println("El cliente no excede el límite de armas permitidas.");
        return false;
    }

}
