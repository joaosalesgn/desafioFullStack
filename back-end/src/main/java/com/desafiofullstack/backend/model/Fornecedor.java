package com.desafiofullstack.backend.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.desafiofullstack.backend.enums.Pessoa;
import com.desafiofullstack.backend.enums.converters.PessoaConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 150, nullable = false)
    private String nome;

    @NotNull
    @Column(length = 100)
    @Convert(converter = PessoaConverter.class)
    private Pessoa pessoa;

    @NotNull
    @Length(max = 18, min = 14)
    @Column(length = 50, nullable = false)
    private String documento;

    @Column(length = 100)
    private String email;

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

    @ManyToMany(mappedBy = "fornecedores", fetch = FetchType.EAGER)
    private List<Empresa> empresas;
}
