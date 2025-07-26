package com.armeria.sistema.modelo.AbstractFactory.Interface;
import com.armeria.sistema.modelo.AbstractFactory.docPago.*;
import com.armeria.sistema.modelo.AbstractFactory.tipoElectronico.*;

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
