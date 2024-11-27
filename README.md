# API Endereços
API RESTful desenvolvida em Spring Boot que fornece um CRUD para gerenciamento de endereços.

## Tecnologias utilizadas:
- Java 21
- Spring Boot
- Maven
- MySQL
- Swagger
- Bean Validation

## Endpoints:
| Método | Endpoint             | Descrição                     |
|--------|-----------------------|------------------------------|
| POST   | `/api/enderecos`      | Cadastra um novo endereço    |
| GET    | `/api/enderecos`      | Consulta todos os endereços  |
| GET    | `/api/enderecos/{id}` | Consulta um endereço por ID  |
| PUT    | `/api/enderecos/{id}` | Atualiza um endereço         |
| DELETE | `/api/enderecos/{id}` | Remove um endereço           |

## Estrutura do projeto:
```plaintext
com.example.demo
├── application
│   └── controllers         # Controladores REST
├── domain
│   ├── models              # Entidades e objetos de domínio
│   │   ├── dtos
│   │   └── entities
│   └── services            # Lógicas de domínio
│       ├── impl            
│       └── interfaces      
├── infrastructure          # Camada de infraestrutura 
│   ├── configurations      
│   ├── factories
│   └── configurations      
└── ApiEnderecosApplication.java
```

## Instalação e execução:

#### Requisitos:
- Java 17 ou superior
- Spring Boot 3.3.5
- MySQL

#### 1. Criação do banco de dados MySQL

```sql
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
```

#### 2. Clone o repositório:
```bash
   git clone https://github.com/samuelmsilva2v/apiEnderecos.git
   cd apiEnderecos
```

#### 3. Instalando as dependências e compilando o projeto com Maven:
```bash
./mvnw clean install
```

#### 4. Executando a aplicação:
```bash
./mvnw spring-boot:run
```

#### 5. Acesse a documentação da API:
  - Documentação da API: http://localhost:8080/swagger-ui/index.html
