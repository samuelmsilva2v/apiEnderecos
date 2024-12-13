package com.example.demo.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.dtos.EnderecoRequestDto;
import com.example.demo.domain.models.dtos.EnderecoResponseDto;
import com.example.demo.domain.models.entities.Endereco;
import com.example.demo.domain.services.impl.EnderecoRepositoryImpl;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

	@PostMapping
	public EnderecoResponseDto post(@RequestBody EnderecoRequestDto dto) {

		var endereco = new Endereco();

		endereco.setId(UUID.randomUUID());
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());
		endereco.setComplemento(dto.getComplemento());
		endereco.setBairro(dto.getBairro());
		endereco.setCidade(dto.getCidade());
		endereco.setUf(dto.getUf());
		endereco.setCep(dto.getCep());

		var repository = new EnderecoRepositoryImpl();
		repository.insert(endereco);
		
		var response = new EnderecoResponseDto();
		response.setId(endereco.getId());
		response.setLogradouro(endereco.getLogradouro());
		response.setNumero(endereco.getNumero());
		response.setComplemento(endereco.getComplemento());
		response.setBairro(endereco.getBairro());
		response.setCidade(endereco.getCidade());
		response.setUf(endereco.getUf());
		response.setCep(endereco.getCep());

		return response;
	}

	@PutMapping("{id}")
	public String put(@PathVariable UUID id, @RequestBody EnderecoRequestDto dto) {

		var repository = new EnderecoRepositoryImpl();

		var endereco = repository.findById(id);

		if (endereco == null)
			return "Endereço não encontrado, verifique o ID informado.";

		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());
		endereco.setComplemento(dto.getComplemento());
		endereco.setBairro(dto.getBairro());
		endereco.setCidade(dto.getCidade());
		endereco.setUf(dto.getUf());
		endereco.setCep(dto.getCep());

		repository.update(id, endereco);

		return "Endereço atualizado com sucesso!";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {

		var repository = new EnderecoRepositoryImpl();

		var endereco = repository.findById(id);

		if (endereco == null)
			return "Endereço não encontrado, verifique o ID informado.";
		
		repository.delete(id);

		return "Endereço excluído com sucesso!";
	}

	@GetMapping
	public List<Endereco> getAll() {
		
		var repository = new EnderecoRepositoryImpl();
		
		return repository.findAll();
	}

	@GetMapping("{id}")
	public Endereco getById(@PathVariable UUID id) {
		
		var repository = new EnderecoRepositoryImpl();
		
		return repository.findById(id);
	}

}
