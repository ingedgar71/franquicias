package com.accenture.franquicias.controllers;


import com.accenture.franquicias.dto.ProductDTO;
import com.accenture.franquicias.dto.ProductProjection;
import com.accenture.franquicias.service.ProductReactiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/product")
public class ProductReactiveController {

    private final ProductReactiveService productReactiveService;

    public ProductReactiveController(ProductReactiveService productReactiveService) {
        this.productReactiveService = productReactiveService;
    }


    @PostMapping("/create")
    public Mono<ResponseEntity<ProductDTO>> save(@RequestBody ProductDTO productDTO) {
        return productReactiveService.save(productDTO)
                .map(savedProduct -> new ResponseEntity<>(savedProduct, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }


    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable("id") Integer id) {
        return productReactiveService.delete(id)
                .thenReturn(ResponseEntity.noContent().build())
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}/update-stock")
    public Mono<ResponseEntity<String>> updateStock(
            @PathVariable("id") Integer idProduct,
            @RequestParam("stock") BigDecimal newStock) {
        return productReactiveService.updateStockDirectly(idProduct, newStock)
                .map(rowsAffected -> ResponseEntity.ok("Stock actualizado correctamente."))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }

    @GetMapping("/top-stock/{idFranchise}")
    public Flux<ProductProjection> getTopStockByBranchForFranchise(@PathVariable Integer idFranchise) {
        return productReactiveService.getTopStockByBranchForFranchise(idFranchise);
    }

    @PutMapping("/{id}/update-name")
    public Mono<ResponseEntity<String>> updateName(
            @PathVariable("id") Integer idProduct,
            @RequestParam("name") String newName) {
        return productReactiveService.updateName(idProduct, newName)
                .map(rowsAffected -> ResponseEntity.ok("Name actualizado correctamente."))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }




}
