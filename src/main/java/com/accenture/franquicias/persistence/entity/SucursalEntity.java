package com.accenture.franquicias.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="sucursal")
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer idSucursal;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_franquicia")
    private FranquiciaEntity franquiciaEntity;

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FranquiciaEntity getFranquiciaEntity() {
        return franquiciaEntity;
    }

    public void setFranquiciaEntity(FranquiciaEntity franquiciaEntity) {
        this.franquiciaEntity = franquiciaEntity;
    }
}
