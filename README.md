# Sistema Bancário - Spring Boot

Um sistema de gerenciamento financeiro desenvolvido em Java Spring Boot que permite o controle de contas bancárias, orçamentos e lançamentos financeiros.

## 📋 Sobre o Projeto

Este projeto implementa um sistema bancário completo baseado no diagrama de classes UML fornecido, incluindo funcionalidades para:

- Gerenciamento de bancos e usuários
- Controle de contas bancárias (corrente, poupança, cartão, investimento)
- Sistema de orçamentos com controle de limites
- Registro de lançamentos financeiros (débito/crédito)
- Autenticação de usuários
- Operações de saldo (adicionar/remover)

## 🏗 Diagrama de Classes

![Diagrama de Classes](https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-whKEPdf1A3WNnBNdbiYcFRrkw0zmD0.png)

O sistema é composto pelas seguintes entidades principais:

### Entidades
- Banco: Representa uma instituição bancária
- Usuario: Usuários do sistema bancário
- Pessoa: Dados pessoais dos usuários
- Conta: Contas bancárias com diferentes tipos
- Orcamento: Controle de orçamentos mensais
- Lancamento: Registros de movimentações financeiras

### Enums
- TipoConta: CORRENTE, POUPANCA, CARTAO, INVESTIMENTO
- TipoLancamento: DEBITO, CREDITO
- Situacao: ABERTO, FECHADO

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.1.0
- Spring Data JPA
- Spring Web
- H2 Database (banco em memória para desenvolvimento)
- Maven (gerenciador de dependências)

## 📦 Estrutura do Projeto

\\\`
src/main/java/com/sistema/bancario/
├── entity/          # Entidades JPA
├── enums/           # Enumerações
├── repository/      # Repositórios JPA
├── service/         # Camada de serviços
├── controller/      # Controladores REST
└── SistemaBancarioApplication.java
\\\`

## ⚙ Configuração e Instalação

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior

### Passos para execução

1. Clone o repositório
\\\`bash
git clone <url-do-repositorio>
cd sistema-bancario
\\\`

2. Compile o projeto
\\\`bash
mvn clean compile
\\\`

3. Execute a aplicação
\\\`bash
mvn spring-boot:run
\\\`

4. Acesse a aplicação
- URL: http://localhost:8080
- Console H2: http://localhost:8080/h2-console
  - JDBC URL: jdbc:h2:mem:testdb
  - Username: sa
  - Password: (deixe em branco)

## 🔧 Configuração do Banco de Dados

O projeto utiliza H2 Database em memória por padrão. As configurações estão no arquivo application.properties:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.defer-datasource-initialization=true

spring.h2.console.enabled=true
