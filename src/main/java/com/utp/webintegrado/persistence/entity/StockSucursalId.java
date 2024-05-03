package com.utp.webintegrado.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class StockSucursalId implements Serializable{

    @Column(name = "id_sucursal")
    private int idSucursal;

    @Column(name = "id_libro")
    private int idLibro;

    public StockSucursalId() {
    }

    public StockSucursalId(int idSucursal, int idLibro) {
        this.idSucursal = idSucursal;
        this.idLibro = idLibro;
    }
}
