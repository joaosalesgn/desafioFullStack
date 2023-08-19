package com.desafiofullstack.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafiofullstack.backend.model.Empresa;
import com.desafiofullstack.backend.repository.EmpresaRepository;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(EmpresaRepository empresaRepository) {
		return args -> {
			empresaRepository.deleteAll();

			Empresa e = new Empresa();
			e.setNomeFantasia("Amanda e Cauã Pizzaria Ltda");
			e.setCnpj("58.935.915/0001-79");
			e.setCep("13075-576");
			e.setLogradouro("Praça Octávio da Silva Leme");
			e.setNumero("326");
			e.setComplemento("Jardim Nossa Senhora Auxiliadora");
			e.setTelefone("(19) 3686-4466");

			empresaRepository.save(e);
		};
	}
}
