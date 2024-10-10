package com.example.demo.domain.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Endereco;
import com.example.demo.domain.services.interfaces.EnderecoRepository;
import com.example.demo.infrastructure.factories.ConnectionFactory;

public class EnderecoRepositoryImpl implements EnderecoRepository {

	@Override
	public void inserir(Endereco endereco) {

		try {

			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement(
					"INSERT INTO endereco(id, logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, endereco.getId().toString());
			statement.setString(2, endereco.getLogradouro());
			statement.setString(3, endereco.getNumero());
			statement.setString(4, endereco.getComplemento());
			statement.setString(5, endereco.getBairro());
			statement.setString(6, endereco.getCidade());
			statement.setString(7, endereco.getUf());
			statement.setString(8, endereco.getCep());
			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(UUID id, Endereco endereco) {

		try {

			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement(
					"UPDATE endereco SET logradouro=?, numero=?, complemento=?, bairro=?, cidade=?, uf=?, cidade=? WHERE id=?");
			statement.setString(1, endereco.getLogradouro());
			statement.setString(2, endereco.getNumero());
			statement.setString(3, endereco.getComplemento());
			statement.setString(4, endereco.getBairro());
			statement.setString(5, endereco.getCidade());
			statement.setString(6, endereco.getUf());
			statement.setString(7, endereco.getCep());
			statement.setString(8, id.toString());
			statement.execute();

			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletar(UUID id) {

		try {

			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();

			var statement = connection.prepareStatement("DELETE FROM endereco WHERE id=?");
			statement.setString(1, id.toString());
			statement.execute();
			
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Endereco> consultar() {
		
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT * FROM endereco");
			var resultSet = statement.executeQuery();
			
			var enderecos = new ArrayList<Endereco>();
			
			while(resultSet.next()) {
				
				var endereco = new Endereco();
				endereco.setId(UUID.fromString(resultSet.getString("id")));
				endereco.setLogradouro(resultSet.getString("logradouro"));
				endereco.setNumero(resultSet.getString("numero"));
				endereco.setComplemento(resultSet.getString("complemento"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setUf(resultSet.getString("uf"));
				endereco.setCep(resultSet.getString("cep"));
				
				enderecos.add(endereco);
			}
			
			connection.close();
			
			return enderecos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Endereco consultarPorId(UUID id) {

		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT * FROM endereco WHERE id=?");
			statement.setString(1, id.toString());
			var resultSet = statement.executeQuery();
			
			Endereco endereco = null;
			
			if(resultSet.next()) {
				
				endereco = new Endereco();
				
				endereco.setId(UUID.fromString(resultSet.getString("id")));
				endereco.setLogradouro(resultSet.getString("logradouro"));
				endereco.setNumero(resultSet.getString("numero"));
				endereco.setComplemento(resultSet.getString("complemento"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setUf(resultSet.getString("uf"));
				endereco.setCep(resultSet.getString("cep"));
				
			}
			
			connection.close();
			
			return endereco;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
