package com.accenture.franquicias.persistence.repository;

import com.accenture.franquicias.persistence.entity.FranchiseEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface IFranchiseReactiveRepository extends ReactiveCrudRepository<FranchiseEntity, Integer> {

    @Query("UPDATE franchise SET franchise_name = :newName WHERE id_franchise = :idFranchise")
    Mono<Integer> updateName(Integer idFranchise, String newName);
}
