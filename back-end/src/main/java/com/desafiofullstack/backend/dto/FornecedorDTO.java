package com.desafiofullstack.backend.dto;

import com.desafiofullstack.backend.enums.Pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FornecedorDTO(
    Long id,
    @NotNull @NotBlank String nome,
    @NotNull Pessoa pessoa,
    @NotNull String documento,
    String email,
    String cep,
    String logradouro,
    String numero,
    String complemento,
    String telefone) {
}
