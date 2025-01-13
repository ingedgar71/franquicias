package com.accenture.franquicias.dto;

import java.math.BigDecimal;

public class ProductProjectionImpl implements ProductProjection {

    private Integer idProduct;
    private String productName;
    private BigDecimal stock;
    private Integer idBranch;
    private String branchName;

    @Override
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    @Override
    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
