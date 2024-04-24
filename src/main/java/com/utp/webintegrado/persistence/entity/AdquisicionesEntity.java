package com.utp.webintegrado.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "adquisiciones")
public class AdquisicionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adquisicion")
    private int idAdquisicion;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false)
    private SucursalEntity sucursal;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", nullable = false)
    private LibroEntity libro;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

}
