package com.utp.webintegrado.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sucursal")
public class SucursalEntity {

    @Id
    @Column(name = "id_sucursal", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSucursal;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

}
