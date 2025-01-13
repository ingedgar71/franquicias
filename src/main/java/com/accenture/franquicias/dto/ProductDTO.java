package com.accenture.franquicias.dto;

import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

public class ProductDTO {

    private Integer idProduct;
    private String name;
    private BigDecimal stock;
    private Integer idBranch;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }
}
