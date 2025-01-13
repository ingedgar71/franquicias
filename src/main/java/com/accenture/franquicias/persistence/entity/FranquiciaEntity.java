package com.accenture.franquicias.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="franquicia")
public class FranquiciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_franquicia")
    private Integer idFranquicia;

    @Column(name = "nombre")
    private String nombre;


    public Integer getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(Integer idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
