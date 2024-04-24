package com.utp.webintegrado.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stock_sucursal")
public class StockSucursalEntity implements Serializable{

    @EmbeddedId
    private StockSucursalEntityPK id;

    @Column(name = "stock", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", insertable = false, updatable = false)
    @MapsId("id_sucursal")
    private SucursalEntity sucursal;

    @ManyToOne
    @JoinColumn(name = "id_libro", insertable = false, updatable = false)
    @MapsId("id_libro")
    private LibroEntity libro;

}
