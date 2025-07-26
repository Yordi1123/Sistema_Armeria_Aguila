package com.armeria.sistema.modelo.ComprobantePago.Interface;

import com.armeria.sistema.modelo.ComprobantePago.docPago.*;
public interface FabricaComprobanteDocumento {
    public boleta creaBoleta();
    public factura creaFactura();
    public docTrasladoArma creaDocTrasladoArma();

}
