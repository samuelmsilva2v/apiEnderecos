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

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

	@PostMapping
	public EnderecoResponseDto post(@RequestBody EnderecoRequestDto dto) {
		// TODO
		return null;
	}
	
	@PutMapping("{id}")
	public EnderecoResponseDto put(@PathVariable UUID id, @RequestBody EnderecoRequestDto dto) {
		// TODO
		return null;
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {
		// TODO
		return null;
	}
	
	@GetMapping
	public List<Endereco> getAll() {
		// TODO
		return null;
	}
	
	@GetMapping("{id}")
	public Endereco getById() {
		// TODO
		return null;
	}
	
}
