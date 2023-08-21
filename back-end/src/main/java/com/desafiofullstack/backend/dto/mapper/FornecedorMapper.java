package com.desafiofullstack.backend.dto.mapper;

import org.springframework.stereotype.Component;

import com.desafiofullstack.backend.dto.FornecedorDTO;
import com.desafiofullstack.backend.model.Fornecedor;

@Component
public class FornecedorMapper {
    
    public FornecedorDTO toDTO(Fornecedor fornecedor) {
        if (fornecedor == null) {
            return null;
        }

        return new FornecedorDTO(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getPessoa(),
            fornecedor.getDocumento(),
            fornecedor.getEmail(),
            fornecedor.getCep(),
            fornecedor.getLogradouro(),
            fornecedor.getNumero(),
            fornecedor.getComplemento(),
            fornecedor.getTelefone()
        );
    }
    
    public Fornecedor toEntity(FornecedorDTO fornecedorDTO) {
        if (fornecedorDTO == null) {
            return null;
        }

        Fornecedor fornecedor = new Fornecedor();
        
        if (fornecedorDTO.id() != null) {
            fornecedor.setId(fornecedorDTO.id());
        }
        fornecedor.setNome(fornecedorDTO.nome());
        fornecedor.setDocumento(fornecedorDTO.documento());
        fornecedor.setPessoa(fornecedorDTO.pessoa());
        fornecedor.setEmail(fornecedorDTO.email());
        fornecedor.setCep(fornecedorDTO.cep());
        fornecedor.setLogradouro(fornecedorDTO.logradouro());
        fornecedor.setNumero(fornecedorDTO.numero());
        fornecedor.setComplemento(fornecedorDTO.complemento());
        fornecedor.setTelefone(fornecedorDTO.telefone());
        return fornecedor;
    }
}
