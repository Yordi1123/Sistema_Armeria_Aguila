package com.armeria.sistema.modelo.ComprobantePago;

public interface FabricaComprobanteDocumento {
    Boleta creaBoleta();
    Factura creaFactura();
    DocumentoTrasladoBienesArmas creaDocumento();
}
