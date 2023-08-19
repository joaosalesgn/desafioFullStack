package com.desafiofullstack.backend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafiofullstack.backend.model.Empresa;
import com.desafiofullstack.backend.repository.EmpresaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/empresa")
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaRepository empresaRepository;

    // Por conta do Lonbok ele já cria o construtor automaticamente
    // (AllArgsConstructor)
    // public EmpresaController(EmpresaRepository empresaRepository)
    // this.empresaRepository = empresaRepository

    @GetMapping
    public List<Empresa> listEmpresas() {
        return empresaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
