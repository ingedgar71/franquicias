package com.accenture.franquicias.controllers;


import com.accenture.franquicias.dto.FranchiseDTO;
import com.accenture.franquicias.service.FranchiseReactiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/franchise")
public class FranchiseReactiveController {

    private final FranchiseReactiveService franchiseReactiveService;

    public FranchiseReactiveController(FranchiseReactiveService franchiseReactiveService) {
        this.franchiseReactiveService = franchiseReactiveService;
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<FranchiseDTO>> save(@RequestBody FranchiseDTO franchiseDTO) {
        return franchiseReactiveService.save(franchiseDTO)
                .map(savedFranchise -> new ResponseEntity<>(savedFranchise, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PutMapping("/{id}/update-name")
    public Mono<ResponseEntity<String>> updateName(
            @PathVariable("id") Integer idFranchise,
            @RequestParam("name") String newName) {
        return franchiseReactiveService.updateName(idFranchise, newName)
                .map(rowsAffected -> ResponseEntity.ok("Name actualizado correctamente."))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }

}
