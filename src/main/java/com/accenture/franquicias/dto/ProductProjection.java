package com.accenture.franquicias.dto;

import java.math.BigDecimal;

public interface ProductProjection {
    Integer getIdProduct();
    String getProductName();
    BigDecimal getStock();
    Integer getIdBranch();


}
