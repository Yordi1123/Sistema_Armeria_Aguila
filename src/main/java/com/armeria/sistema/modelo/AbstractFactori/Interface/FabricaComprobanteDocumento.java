package com.armeria.sistema.modelo.AbstractFactori.Interface;

import com.armeria.sistema.modelo.AbstractFactori.docPago.*;
public interface FabricaComprobanteDocumento {
    public boleta creaBoleta();
    public factura creaFactura();
    public docTrasladoArma creaDocTrasladoArma();

}
