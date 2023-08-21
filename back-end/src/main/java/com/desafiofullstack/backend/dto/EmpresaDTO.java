package com.desafiofullstack.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpresaDTO(
    Long id,
    @NotNull @NotBlank String nomeFantasia,
    @NotNull String cnpj,
    String cep,
    String logradouro,
    String numero,
    String complemento,
    String telefone) {

}
