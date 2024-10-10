CREATE DATABASE bd_apiEnderecos;

USE bd_apiEnderecos;

CREATE TABLE endereco (
    id CHAR(36) PRIMARY KEY NOT NULL, -- UUID será armazenado como CHAR(36)
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL, -- UF é um campo de 2 caracteres (ex: SP, RJ)
    cep VARCHAR(10) NOT NULL, -- CEP formatado como string para permitir hífen
    PRIMARY KEY (id)
);
