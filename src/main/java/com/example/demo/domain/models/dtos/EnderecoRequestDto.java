package com.example.demo.domain.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EnderecoRequestDto {

	@NotEmpty(message = "O logradouro é obrigatório.")
	private String logradouro;
	
	@NotEmpty(message = "O número é obrigatório.")
	private String numero;
	
	private String complemento;
	
	@NotEmpty(message = "O bairro é obrigatório.")
	private String bairro;
	
	@NotEmpty(message = "A cidade é obrigatória.")
	private String cidade;
	
	@NotEmpty(message = "A UF é obrigatória.")
	private String uf;
	
	@NotEmpty(message = "O CEP é obrigatório.")
	@Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP inválido. O formato deve ser #####-###.")
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
