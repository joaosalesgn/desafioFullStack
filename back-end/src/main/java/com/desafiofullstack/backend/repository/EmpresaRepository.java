package com.desafiofullstack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiofullstack.backend.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
