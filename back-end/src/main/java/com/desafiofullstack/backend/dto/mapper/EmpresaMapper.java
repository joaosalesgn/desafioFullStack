package com.desafiofullstack.backend.dto.mapper;

import org.springframework.stereotype.Component;

import com.desafiofullstack.backend.dto.EmpresaDTO;
import com.desafiofullstack.backend.model.Empresa;

@Component
public class EmpresaMapper {
    
    public EmpresaDTO toDTO(Empresa empresa) {
        if (empresa == null) {
            return null;
        }

        return new EmpresaDTO(
            empresa.getId(),
            empresa.getNomeFantasia(),
            empresa.getCnpj(),
            empresa.getCep(),
            empresa.getLogradouro(),
            empresa.getNumero(),
            empresa.getComplemento(),
            empresa.getTelefone()
        );
    }
    
    public Empresa toEntity(EmpresaDTO empresaDTO) {
        if (empresaDTO == null) {
            return null;
        }

        Empresa empresa = new Empresa();
        
        if (empresaDTO.id() != null) {
            empresa.setId(empresaDTO.id());
        }
        empresa.setNomeFantasia(empresaDTO.nomeFantasia());
        empresa.setCnpj(empresaDTO.cnpj());
        empresa.setCep(empresaDTO.cep());
        empresa.setLogradouro(empresaDTO.logradouro());
        empresa.setNumero(empresaDTO.numero());
        empresa.setComplemento(empresaDTO.complemento());
        empresa.setTelefone(empresaDTO.telefone());
        return empresa;
    }
}
