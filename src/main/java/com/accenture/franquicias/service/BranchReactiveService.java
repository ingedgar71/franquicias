package com.accenture.franquicias.service;

import com.accenture.franquicias.dto.BranchDTO;
import com.accenture.franquicias.mapper.IBranchMapper;
import com.accenture.franquicias.persistence.entity.BranchEntity;
import com.accenture.franquicias.persistence.repository.IBranchReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BranchReactiveService {

    private final IBranchReactiveRepository branchReactiveRepository;
    private final IBranchMapper branchMapper;

    public BranchReactiveService(IBranchReactiveRepository branchReactiveRepository, IBranchMapper branchMapper) {
        this.branchReactiveRepository = branchReactiveRepository;
        this.branchMapper = branchMapper;
    }


    /**
     * Método del servicio que permite agregar una nueva franquicia de manera reactiva
     */
    public Mono<BranchDTO> save(BranchDTO branchDTO) {
        BranchEntity branchEntity = branchMapper.toBranchEntity(branchDTO);

        return branchReactiveRepository.save(branchEntity)
                .doOnNext(savedEntity -> System.out.println("id franchiseEntity después de guardar: " + savedEntity.getIdFranchise()))
                .map(branchMapper::toBranchDTO);
    }

    public Mono<Integer> updateName(Integer idBranch, String newName) {
        return branchReactiveRepository.updateName(idBranch, newName)
                .flatMap(rowsAffected -> {
                    if (rowsAffected == 0) {
                        return Mono.error(new RuntimeException("No se pudo actualizar el nombre, Sucursal no encontrada."));
                    }
                    return Mono.just(rowsAffected);
                });
    }
}
