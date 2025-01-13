package com.accenture.franquicias.mapper;

import com.accenture.franquicias.dto.FranchiseDTO;
import com.accenture.franquicias.persistence.entity.FranchiseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IFranchiseMapper {
    FranchiseEntity toFranchiseEntity(FranchiseDTO franchiseDTO);

    @InheritInverseConfiguration
    FranchiseDTO toFranchiseDTO(FranchiseEntity franchiseEntity);

}
