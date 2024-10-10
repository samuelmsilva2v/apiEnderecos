package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Endereco;

public interface EnderecoRepository {

	void insert(Endereco endereco);
	
	void update(UUID id, Endereco endereco);
	
	void delete(UUID id);
	
	List<Endereco> findAll();
	
	Endereco findById(UUID id);
}
