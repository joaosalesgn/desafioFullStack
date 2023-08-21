package com.desafiofullstack.backend.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 150, nullable = false)
    private String nomeFantasia;

    @NotNull
    @Length(max = 18, min = 14)
    @Column(length = 50, nullable = false)
    private String cnpj;

    @Column(length = 10)
    private String cep;

    @Column(length = 100)
    private String logradouro;

    @Column(length = 10)
    private String numero;

    @Column(length = 200)
    private String complemento;

    @Column(length = 50)
    private String telefone;

}
