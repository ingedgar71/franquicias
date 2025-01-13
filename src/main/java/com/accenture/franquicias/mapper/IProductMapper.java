package com.accenture.franquicias.mapper;

import com.accenture.franquicias.dto.ProductDTO;
import com.accenture.franquicias.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    ProductEntity toProductEntity(ProductDTO productDTO);

    @InheritInverseConfiguration
    ProductDTO toProductDTO(ProductEntity productEntity);

}
