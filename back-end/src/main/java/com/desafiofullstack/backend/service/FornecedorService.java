package com.desafiofullstack.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafiofullstack.backend.dto.FornecedorDTO;
import com.desafiofullstack.backend.dto.mapper.FornecedorMapper;
import com.desafiofullstack.backend.exception.RecordNotFoundException;
import com.desafiofullstack.backend.repository.FornecedorRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class FornecedorService {
    
    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorService(FornecedorRepository fornecedorRepository, FornecedorMapper fornecedorMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }

    public List<FornecedorDTO> listFornecedores() {

        return fornecedorRepository.findAll()
            .stream()
            .map(fornecedorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FornecedorDTO findById(@NotNull @Positive Long codigoFornecedor) {
        return fornecedorRepository.findById(codigoFornecedor).map(fornecedorMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(codigoFornecedor));
    }

    public FornecedorDTO create(@Valid FornecedorDTO fornecedorDTO) {
        return fornecedorMapper.toDTO(fornecedorRepository.save(fornecedorMapper.toEntity(fornecedorDTO)));
    }

    public FornecedorDTO update(@NotNull @Positive Long codigoFornecedor, @Valid FornecedorDTO fornecedorDTO) {
        return fornecedorRepository.findById(codigoFornecedor)
            .map(response -> {
                response.setNome(fornecedorDTO.nome());
                response.setPessoa(fornecedorDTO.pessoa());
                response.setDocumento(fornecedorDTO.documento());
                response.setEmail(fornecedorDTO.email());
                response.setCep(fornecedorDTO.cep());
                response.setLogradouro(fornecedorDTO.logradouro());
                response.setNumero(fornecedorDTO.numero());
                response.setComplemento(fornecedorDTO.complemento());
                response.setTelefone(fornecedorDTO.telefone());
                return fornecedorMapper.toDTO(fornecedorRepository.save(response));
            }).orElseThrow(() -> new RecordNotFoundException(codigoFornecedor));
    }

    public void delete(@PathVariable("id") @NotNull @Positive Long codigoFornecedor) {

        fornecedorRepository.delete(fornecedorRepository.findById(codigoFornecedor)
                                    .orElseThrow(() -> new RecordNotFoundException(codigoFornecedor)));
    }
}
