package com.accenture.franquicias.persistence.repository;

import com.accenture.franquicias.dto.ProductProjection;
import com.accenture.franquicias.persistence.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface IProductReactiveRepository extends ReactiveCrudRepository<ProductEntity, Integer> {

    @Query("UPDATE product SET stock = :stock WHERE id_product = :idProduct")
    Mono<Integer> updateStock(Integer idProduct, BigDecimal stock);


    @Query("""
           SELECT 
               p.id_product,
               p.product_name,
               p.stock,
               b.id_branch               
           FROM product p
           INNER JOIN branch b ON p.id_branch = b.id_branch
           INNER JOIN franchise f ON b.id_franchise = f.id_franchise
           WHERE f.id_franchise = :idFranchise
             AND (p.stock, p.id_branch) IN (
                 SELECT MAX(p2.stock), p2.id_branch
                 FROM product p2
                 INNER JOIN branch b2 ON p2.id_branch = b2.id_branch
                 WHERE b2.id_franchise = :idFranchise
                 GROUP BY p2.id_branch
             )
           ORDER BY b.id_branch
           """)
    Flux<ProductProjection> findTopStockByBranchForFranchise(Integer idFranchise);

    @Query("UPDATE product SET product_name = :newName WHERE id_product = :idProduct")
    Mono<Integer> updateName(Integer idProduct, String newName);
}
