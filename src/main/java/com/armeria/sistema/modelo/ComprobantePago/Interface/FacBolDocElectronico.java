package com.armeria.sistema.modelo.ComprobantePago.Interface;
import com.armeria.sistema.modelo.ComprobantePago.docPago.*;
import com.armeria.sistema.modelo.ComprobantePago.tipoElectronico.*;

public class FacBolDocElectronico implements FabricaComprobanteDocumento {

    @Override
    public boleta creaBoleta() {
        return new boletaElectronica();
    }

    @Override
    public factura creaFactura() {
        return new facturaElectronica();
    }

    @Override
    public docTrasladoArma creaDocTrasladoArma() {
        return new docElectronico();
    }
    
}
