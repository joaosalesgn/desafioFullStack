package com.desafiofullstack.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafiofullstack.backend.exception.RecordNotFoundException;
import com.desafiofullstack.backend.model.Empresa;
import com.desafiofullstack.backend.repository.EmpresaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> listEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa findById(@NotNull @Positive Long codigoEmpresa) {
        return empresaRepository.findById(codigoEmpresa).orElseThrow(() -> new RecordNotFoundException(codigoEmpresa));
    }

    public Empresa create(@Valid Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> update(@NotNull @Positive Long codigoEmpresa, @Valid Empresa empresa) {
        return empresaRepository.findById(codigoEmpresa)
            .map(response -> {
                response.setNomeFantasia(empresa.getNomeFantasia());
                response.setCnpj(empresa.getCnpj());
                response.setCep(empresa.getCep());
                response.setLogradouro(empresa.getLogradouro());
                response.setNumero(empresa.getNumero());
                response.setComplemento(empresa.getComplemento());
                response.setTelefone(empresa.getTelefone());
                return empresaRepository.save(response);
            });
    }

    public Boolean delete(@PathVariable("id") @NotNull @Positive Long codigoEmpresa) {
        return empresaRepository.findById(codigoEmpresa)
            .map(response -> {
                empresaRepository.deleteById(codigoEmpresa);
                return true;
            })
            .orElse(false);
    }
}
