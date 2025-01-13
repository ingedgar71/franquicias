package com.accenture.franquicias.persistence.repository;

import com.accenture.franquicias.persistence.entity.BranchEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IBranchReactiveRepository extends ReactiveCrudRepository<BranchEntity, Integer> {

    @Query("UPDATE branch SET branch_name = :newName WHERE id_branch = :idBranch")
    Mono<Integer> updateName(Integer idBranch, String newName);
}
