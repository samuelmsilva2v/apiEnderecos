package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Endereco;

public interface EnderecoRepository {

	void inserir(Endereco endereco);
	
	void atualizar(UUID id, Endereco endereco);
	
	void deletar(UUID id);
	
	List<Endereco> consultar();
	
	Endereco consultarPorId(UUID id);
}
