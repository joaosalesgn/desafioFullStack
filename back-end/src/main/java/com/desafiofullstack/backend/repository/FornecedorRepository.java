package com.desafiofullstack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiofullstack.backend.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
