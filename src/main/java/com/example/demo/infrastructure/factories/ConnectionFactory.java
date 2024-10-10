package com.example.demo.infrastructure.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() throws Exception {
		
		var host = "jdbc:mysql://localhost:3306/bd_apienderecos";
		var user = "root";
		var pass = "password";
		
		return DriverManager.getConnection(host, user, pass);
	}
}
