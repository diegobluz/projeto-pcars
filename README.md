# PCars

Sistema web para gerenciamento de uma concessionária, desenvolvido com Java e Spring Boot.

O projeto reúne cadastro e gerenciamento de clientes, veículos e vendas, utilizando persistência com Spring Data JPA e MySQL, além de páginas HTML renderizadas com Thymeleaf e endpoints REST para acesso aos dados.

## Sobre o projeto

O PCars foi criado para praticar o desenvolvimento de aplicações web completas com Spring Boot, combinando backend, persistência, interface web e APIs REST.

A aplicação organiza operações comuns de uma concessionária, como cadastro de clientes e veículos, registro de vendas e consulta das informações cadastradas.

## Funcionalidades

- Cadastro de clientes
- Consulta de clientes
- Atualização de clientes
- Exclusão de clientes
- Cadastro de veículos
- Consulta de veículos
- Atualização de veículos
- Exclusão de veículos
- Registro de vendas
- Consulta de vendas
- Atualização e exclusão de vendas
- Interface web com Thymeleaf
- Endpoints REST para clientes, veículos e vendas
- Persistência de dados em MySQL

## Tecnologias utilizadas

### Backend

- Java 17
- Spring Boot 3.2
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- Lombok

### Frontend

- HTML
- CSS
- JavaScript
- Thymeleaf

### Banco de dados

- MySQL
- MySQL Connector/J

### Build e ferramentas

- Maven
- Maven Wrapper
- Git
- GitHub

## Arquitetura

O projeto utiliza uma organização em camadas:

```text
src/main/java/com/projectcars/main/
├── controller/
├── models/
├── repository/
└── services/
```

### Controller

Responsável por receber as requisições HTTP e direcioná-las para a camada de serviço.

O projeto possui controladores REST dedicados a:

- Clientes
- Veículos
- Vendas

### Services

Centraliza a lógica de aplicação e faz a comunicação entre os controladores e os repositórios.

### Repository

Utiliza Spring Data JPA para acesso e persistência das entidades no MySQL.

### Models

Representa as principais entidades do sistema:

- `Cliente`
- `Veiculo`
- `Venda`

## Fluxo da aplicação

```text
Browser / Cliente HTTP
        │
        ▼
Controller
        │
        ▼
Service
        │
        ▼
Repository
        │
        ▼
Spring Data JPA / Hibernate
        │
        ▼
MySQL
```

## API REST

### Clientes

```text
POST   /cliente/adicionar
GET    /cliente/listar
GET    /cliente/buscar/{id}
PUT    /cliente/alterar/{id}
DELETE /cliente/excluir/{id}
```

### Veículos

```text
POST   /veiculo/adicionar
GET    /veiculo/listar
GET    /veiculo/buscar/{id}
PUT    /veiculo/alterar/{id}
DELETE /veiculo/excluir/{id}
```

### Vendas

```text
POST   /venda/adicionar
GET    /venda/listar
GET    /venda/buscar/{id}
PUT    /venda/alterar/{id}
DELETE /venda/excluir/{id}
```

## Interface web

O projeto possui páginas para:

- Página inicial
- Cadastro de clientes
- Cadastro de veículos
- Registro de vendas
- Listagem de dados

Os templates ficam em:

```text
src/main/resources/templates/
```

E os arquivos estáticos em:

```text
src/main/resources/static/
```

## Como executar

### Pré-requisitos

- Java 17 ou superior
- MySQL Server
- Git

O Maven Wrapper já está incluído no projeto.

### 1. Clone o repositório

```bash
git clone https://github.com/diegobluz/projeto-pcars.git
cd projeto-pcars
```

### 2. Configure o banco de dados

A configuração atual utiliza MySQL e está localizada em:

```text
src/main/resources/application.properties
```

Para um ambiente real, utilize variáveis de ambiente para URL, usuário e senha do banco em vez de manter credenciais diretamente no repositório.

Exemplo:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

### 3. Execute a aplicação

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
mvnw.cmd spring-boot:run
```

A aplicação utiliza por padrão a porta:

```text
8080
```

## Conceitos praticados

- Programação Orientada a Objetos
- Spring Boot
- API REST
- Arquitetura em camadas
- Injeção de dependência
- Spring Data JPA
- Hibernate
- CRUD
- Modelagem de entidades
- Persistência com MySQL
- Thymeleaf
- Maven
- Integração frontend/backend
- Git e GitHub

## Possíveis melhorias

- Externalizar todas as configurações sensíveis
- Adicionar DTOs para requests e responses da API
- Implementar tratamento global de exceções
- Adicionar documentação OpenAPI/Swagger
- Criar testes unitários e de integração
- Adicionar Docker e Docker Compose
- Padronizar respostas de erro da API
- Adicionar autenticação e autorização
- Adicionar paginação e filtros nas consultas

## Autor

**Diego Luz**

Projeto desenvolvido para fins de estudo e prática com Java, Spring Boot e desenvolvimento web.
