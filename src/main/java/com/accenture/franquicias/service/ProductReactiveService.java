package com.accenture.franquicias.service;

import com.accenture.franquicias.dto.ProductDTO;
import com.accenture.franquicias.dto.ProductProjection;
import com.accenture.franquicias.mapper.IProductMapper;
import com.accenture.franquicias.persistence.entity.ProductEntity;
import com.accenture.franquicias.persistence.repository.IProductReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class ProductReactiveService {

    private final IProductReactiveRepository productReactiveRepository;
    private final IProductMapper productMapper;

    public ProductReactiveService(IProductReactiveRepository productReactiveRepository, IProductMapper productMapper) {
        this.productReactiveRepository = productReactiveRepository;
        this.productMapper = productMapper;
    }


    /**
     * Método del servicio que permite agregar un nuevo Producto de manera reactiva
     */
    public Mono<ProductDTO> save(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.toProductEntity(productDTO);

        return productReactiveRepository.save(productEntity)
                .map(productMapper::toProductDTO);
    }

    /**
     * Método del servicio que permite eliminar un Producto de manera reactiva
     */
    public Mono<Void> delete(Integer id) {
        return productReactiveRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado con id: " + id)))
                .flatMap(product -> productReactiveRepository.deleteById(id));
    }

    /**
     * Método del servicio que permite modificar un Producto de manera reactiva
     */
    public Mono<ProductEntity> updateStock(Integer idProduct, BigDecimal newStock) {
        return productReactiveRepository.findById(idProduct)
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado con id: " + idProduct)))
                .flatMap(product -> {
                    // Actualiza el stock solo si el producto existe
                    product.setStock(newStock);
                    return productReactiveRepository.save(product); // Guarda el producto con el nuevo stock
                });
    }

    public Mono<Integer> updateStockDirectly(Integer idProduct, BigDecimal newStock) {
        return productReactiveRepository.updateStock(idProduct, newStock)
                .flatMap(rowsAffected -> {
                    if (rowsAffected == 0) {
                        return Mono.error(new RuntimeException("No se pudo actualizar el stock, producto no encontrado."));
                    }
                    return Mono.just(rowsAffected);
                });
    }

    public Flux<ProductProjection> getTopStockByBranchForFranchise(Integer idFranchise) {
        return productReactiveRepository.findTopStockByBranchForFranchise(idFranchise);
    }

    public Mono<Integer> updateName(Integer idProduct, String newName) {
        return productReactiveRepository.updateName(idProduct, newName)
                .flatMap(rowsAffected -> {
                    if (rowsAffected == 0) {
                        return Mono.error(new RuntimeException("No se pudo actualizar el nombre, Producto no encontrado."));
                    }
                    return Mono.just(rowsAffected);
                });
    }



}
