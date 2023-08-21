package com.desafiofullstack.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafiofullstack.backend.dto.EmpresaDTO;
import com.desafiofullstack.backend.dto.mapper.EmpresaMapper;
import com.desafiofullstack.backend.exception.RecordNotFoundException;
import com.desafiofullstack.backend.repository.EmpresaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    public List<EmpresaDTO> listEmpresas() {

        return empresaRepository.findAll()
            .stream()
            .map(empresaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmpresaDTO findById(@NotNull @Positive Long codigoEmpresa) {
        return empresaRepository.findById(codigoEmpresa).map(empresaMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(codigoEmpresa));
    }

    public EmpresaDTO create(@Valid EmpresaDTO empresaDTO) {
        return empresaMapper.toDTO(empresaRepository.save(empresaMapper.toEntity(empresaDTO)));
    }

    public EmpresaDTO update(@NotNull @Positive Long codigoEmpresa, @Valid EmpresaDTO empresaDTO) {
        return empresaRepository.findById(codigoEmpresa)
            .map(response -> {
                response.setNomeFantasia(empresaDTO.nomeFantasia());
                response.setCnpj(empresaDTO.cnpj());
                response.setCep(empresaDTO.cep());
                response.setLogradouro(empresaDTO.logradouro());
                response.setNumero(empresaDTO.numero());
                response.setComplemento(empresaDTO.complemento());
                response.setTelefone(empresaDTO.telefone());
                return empresaMapper.toDTO(empresaRepository.save(response));
            }).orElseThrow(() -> new RecordNotFoundException(codigoEmpresa));
    }

    public void delete(@PathVariable("id") @NotNull @Positive Long codigoEmpresa) {

        empresaRepository.delete(empresaRepository.findById(codigoEmpresa)
                                    .orElseThrow(() -> new RecordNotFoundException(codigoEmpresa)));
    }
}
