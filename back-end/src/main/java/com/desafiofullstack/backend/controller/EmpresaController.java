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

import com.desafiofullstack.backend.dto.EmpresaDTO;
import com.desafiofullstack.backend.service.EmpresaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<EmpresaDTO> listEmpresas() {
        return empresaService.listEmpresas();
    }

    @GetMapping("/{id}")
    public EmpresaDTO findById(@PathVariable("id")  @NotNull @Positive Long codigoEmpresa) {
        return empresaService.findById(codigoEmpresa);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmpresaDTO create(@RequestBody @Valid EmpresaDTO empresaDTO) {
        return empresaService.create(empresaDTO);
    }
    
    @PutMapping("/{id}")
    public EmpresaDTO update(@PathVariable("id") @NotNull @Positive Long codigoEmpresa, @RequestBody EmpresaDTO empresaDTO) {
        return empresaService.update(codigoEmpresa, empresaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long codigoEmpresa) {
        empresaService.delete(codigoEmpresa);
    }
}
