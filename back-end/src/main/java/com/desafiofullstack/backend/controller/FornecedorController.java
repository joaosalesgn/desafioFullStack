package com.desafiofullstack.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafiofullstack.backend.dto.FornecedorDTO;
import com.desafiofullstack.backend.service.FornecedorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public List<FornecedorDTO> listFornecedores() {
        return fornecedorService.listFornecedores();
    }

    @GetMapping("/{id}")
    public FornecedorDTO findById(@PathVariable("id")  @NotNull @Positive Long codigoFornecedor) {
        return fornecedorService.findById(codigoFornecedor);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FornecedorDTO create(@RequestBody @Valid FornecedorDTO fornecedorDTO) {
        return fornecedorService.create(fornecedorDTO);
    }
    
    @PutMapping("/{id}")
    public FornecedorDTO update(@PathVariable("id") @NotNull @Positive Long codigoFornecedor, @RequestBody FornecedorDTO fornecedorDTO) {
        return fornecedorService.update(codigoFornecedor, fornecedorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long codigoFornecedor) {
        fornecedorService.delete(codigoFornecedor);
    }
}
