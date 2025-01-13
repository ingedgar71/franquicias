package com.accenture.franquicias.mapper;

import com.accenture.franquicias.dto.BranchDTO;
import com.accenture.franquicias.persistence.entity.BranchEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBranchMapper {
    BranchEntity toBranchEntity(BranchDTO branchDTO);

    @InheritInverseConfiguration
    BranchDTO toBranchDTO(BranchEntity branchEntity);

}
