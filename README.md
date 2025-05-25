# DasaAPI - Sistema de Gerenciamento de Estoque

## Visão Geral

DasaAPI é uma API RESTful desenvolvida com Spring Boot para gerenciar estoque de materiais. O sistema permite controlar materiais, códigos de barras, movimentações de estoque e usuários, fornecendo uma interface robusta para operações de gerenciamento de inventário.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação base do projeto
- **Spring Boot 3.4.5**: Framework para criação de aplicações Java
- **Spring Data JPA**: Para persistência de dados e operações com banco de dados
- **MySQL**: Sistema de gerenciamento de banco de dados relacional
- **Flyway**: Ferramenta para migração e versionamento de banco de dados
- **Lombok**: Biblioteca para redução de código boilerplate
- **MapStruct 1.5.5**: Framework para mapeamento entre objetos
- **Swagger/OpenAPI 2.5.0**: Documentação automatizada da API
- **Maven**: Ferramenta de gerenciamento de dependências e build

## Estrutura do Projeto

```
DasaAPI/
├── src/
│   ├── main/
│   │   ├── java/com/fiap/dasa_api/
│   │   │   ├── config/              # Configurações da aplicação
│   │   │   ├── controllers/         # Controladores REST
│   │   │   ├── domain/              # Entidades e DTOs
│   │   │   │   ├── dto/             # Objetos de transferência de dados
│   │   │   │   └── entities/        # Entidades JPA
│   │   │   ├── infra/               # Infraestrutura e utils
│   │   │   ├── repositories/        # Interfaces de repositório JPA
│   │   │   ├── service/             # Camada de serviço
│   │   │   └── specs/               # Especificações e interfaces
│   │   └── resources/               # Recursos da aplicação
│   └── test/                        # Testes unitários e de integração
└── pom.xml                          # Configuração Maven
```

## Entidades Principais

O sistema é composto pelas seguintes entidades principais:

1. **Material**: Representa os materiais gerenciados no sistema
2. **TypeMaterial**: Categorias ou tipos de materiais
3. **User**: Usuários do sistema
4. **Stock**: Controle de estoque
5. **Barcode**: Códigos de barras associados aos materiais
6. **TypeMovement**: Tipos de movimentação no estoque

## Endpoints da API

A API oferece os seguintes endpoints principais:

### Materiais
- `GET /material`: Listar todos os materiais
- `GET /material/{id}`: Buscar material pelo ID
- `POST /material`: Criar novo material
- `PUT /material`: Atualizar material existente
- `DELETE /material/{id}`: Excluir material

### Estoque
- Endpoints para gerenciar as operações de estoque

### Usuários
- Endpoints para gerenciar os usuários do sistema

### Tipos de Material
- Endpoints para gerenciar os tipos/categorias de materiais

### Códigos de Barras
- Endpoints para gerenciar os códigos de barras dos materiais

### Tipos de Movimentação
- Endpoints para gerenciar os tipos de movimentação no estoque

## Arquitetura

O projeto segue uma arquitetura em camadas, seguindo boas práticas de desenvolvimento:

1. **Camada de Controladores**: Responsável por receber requisições HTTP e mapear para os serviços correspondentes
2. **Camada de Serviço**: Implementa a lógica de negócio da aplicação
3. **Camada de Repositório**: Interfaces para acesso aos dados persistidos
4. **Camada de Domínio**: Contém as entidades de domínio e DTOs para transferência de dados

## Documentação da API

A API é documentada usando Swagger/OpenAPI. Após iniciar a aplicação, a documentação estará disponível em:
```
http://localhost:8080/swagger-ui.html
```

## Configuração e Execução

### Pré-requisitos
- JDK 17
- MySQL
- Maven

### Passos para execução
1. Clone o repositório
2. Configure as propriedades do banco de dados em `application.properties`
3. Execute o comando: `mvn spring-boot:run`

## Migrations e Banco de Dados

O projeto utiliza Flyway para gerenciar as migrações de banco de dados, garantindo que o esquema do banco de dados seja versionado e mantido de forma consistente.

## Desenvolvimento

O projeto segue padrões de Clean Code e utiliza diversos recursos para facilitar o desenvolvimento:
- DTOs para transferência de dados
- Validação de dados com Bean Validation
- Mapeamento objeto-relacional com JPA
- Conversão entre entidades e DTOs com MapStruct

## Testes

O projeto utiliza o Spring Boot Test para testes unitários e de integração, garantindo a qualidade e robustez da aplicação.

---

Desenvolvido como projeto acadêmico para FIAP.
