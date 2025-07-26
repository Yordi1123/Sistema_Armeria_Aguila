package com.armeria.sistema.modelo.AbstractFactory.Interface;

import com.armeria.sistema.modelo.AbstractFactory.docPago.*;
public interface FabricaComprobanteDocumento {
    public boleta creaBoleta();
    public factura creaFactura();
    public docTrasladoArma creaDocTrasladoArma();

}
