package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.models.dtos.EnderecoRequestDto;
import com.example.demo.domain.models.dtos.EnderecoResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiEnderecosApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private static UUID id; 
	
	@Test
	@Order(1)
	void cadastrarEnderecoTest() throws Exception {
		
		var faker = new Faker(Locale.forLanguageTag("pt-BR"));
		
		var request = new EnderecoRequestDto();
		request.setLogradouro(faker.address().streetName());
		request.setNumero(faker.address().buildingNumber());
		request.setComplemento(faker.address().secondaryAddress());
		request.setBairro(faker.address().lastName());
		request.setCidade(faker.address().city());
		request.setUf("SP");
		request.setCep(faker.number().digits(5)+ "-" + faker.number().digits(3));
		
		var result = mockMvc.perform(post("/api/enderecos")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andReturn();
		
		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		var response = objectMapper.readValue(content, EnderecoResponseDto.class);
		
		assertNotNull(response.getId());
		assertEquals(response.getLogradouro(), request.getLogradouro());
		assertEquals(response.getNumero(), request.getNumero());
		assertEquals(response.getComplemento(), request.getComplemento());
		assertEquals(response.getBairro(), request.getBairro());
		assertEquals(response.getCidade(), request.getCidade());
		assertEquals(response.getUf(), request.getUf());
		assertEquals(response.getCep(), request.getCep());
		
		id = response.getId();
	}

}
