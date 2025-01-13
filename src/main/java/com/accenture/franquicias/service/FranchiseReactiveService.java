package com.accenture.franquicias.service;

import com.accenture.franquicias.dto.FranchiseDTO;
import com.accenture.franquicias.mapper.IFranchiseMapper;
import com.accenture.franquicias.persistence.entity.FranchiseEntity;
import com.accenture.franquicias.persistence.repository.IFranchiseReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class FranchiseReactiveService {

    private final IFranchiseReactiveRepository franchiseReactiveRepository;
    private final IFranchiseMapper franchiseMapper;

    public FranchiseReactiveService(IFranchiseReactiveRepository franchiseReactiveRepository, IFranchiseMapper franchiseMapper) {
        this.franchiseReactiveRepository = franchiseReactiveRepository;
        this.franchiseMapper = franchiseMapper;
    }

    /**
     * Método del servicio que permite agregar una nueva franquicia de manera reactiva
     */
    public Mono<FranchiseDTO> save(FranchiseDTO franchiseDTO) {
        FranchiseEntity franchiseEntity = franchiseMapper.toFranchiseEntity(franchiseDTO);

        return franchiseReactiveRepository.save(franchiseEntity)
                .doOnNext(savedEntity -> System.out.println("id franchiseEntity después de guardar: " + savedEntity.getIdFranchise()))
                .map(franchiseMapper::toFranchiseDTO);
    }

    public Mono<Integer> updateName(Integer idFranchise, String newName) {
        return franchiseReactiveRepository.updateName(idFranchise, newName)
                .flatMap(rowsAffected -> {
                    if (rowsAffected == 0) {
                        return Mono.error(new RuntimeException("No se pudo actualizar el nombre, Franquicia no encontrada."));
                    }
                    return Mono.just(rowsAffected);
                });
    }
}
