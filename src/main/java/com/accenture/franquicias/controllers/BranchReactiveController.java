package com.accenture.franquicias.controllers;


import com.accenture.franquicias.dto.BranchDTO;
import com.accenture.franquicias.service.BranchReactiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branch")
public class BranchReactiveController {

    private final BranchReactiveService branchReactiveService;

    public BranchReactiveController(BranchReactiveService branchReactiveService) {
        this.branchReactiveService = branchReactiveService;
    }


    @PostMapping("/create")
    public Mono<ResponseEntity<BranchDTO>> save(@RequestBody BranchDTO branchDTO) {
        return branchReactiveService.save(branchDTO)
                .map(savedBranch -> new ResponseEntity<>(savedBranch, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PutMapping("/{id}/update-name")
    public Mono<ResponseEntity<String>> updateName(
            @PathVariable("id") Integer idBranch,
            @RequestParam("name") String newName) {
        return branchReactiveService.updateName(idBranch, newName)
                .map(rowsAffected -> ResponseEntity.ok("Name actualizado correctamente."))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }


}
