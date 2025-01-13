package com.accenture.franquicias.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="stock")
    private BigDecimal stock;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursalEntity;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public SucursalEntity getSucursalEntity() {
        return sucursalEntity;
    }

    public void setSucursalEntity(SucursalEntity sucursalEntity) {
        this.sucursalEntity = sucursalEntity;
    }
}
