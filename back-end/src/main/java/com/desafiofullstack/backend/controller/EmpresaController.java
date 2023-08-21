package com.desafiofullstack.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.desafiofullstack.backend.model.Empresa;
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
    public List<Empresa> listEmpresas() {
        return empresaService.listEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa findById(@PathVariable("id")  @NotNull @Positive Long codigoEmpresa) {
        return empresaService.findById(codigoEmpresa);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa create(@RequestBody @Valid Empresa empresa) {
        return empresaService.create(empresa);
    }
    
    @PutMapping("/{id}")
    public Empresa update(@PathVariable("id") @NotNull @Positive Long codigoEmpresa, @RequestBody Empresa empresa) {
        return empresaService.update(codigoEmpresa, empresa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long codigoEmpresa) {
        empresaService.delete(codigoEmpresa);
    }
}
