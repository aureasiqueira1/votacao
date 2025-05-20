# 🗳️ Sistema de Votação para Cooperativas

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para gerenciamento de pautas e sessões de votação em cooperativas, com integração a banco de dados **PostgreSQL**.

---

## 🚀 Tecnologias e Arquitetura

- ✅ **Spring Boot 3**
- ✅ **JDK 17.0.12**
- ✅ **MapStruct** para mapeamento entre DTOs e entidades
- ✅ **PostgreSQL**
- ✅ **Arquitetura Hexagonal (Ports and Adapters)**

---

## 📐 Arquitetura Hexagonal

Este projeto segue os princípios da **Arquitetura Hexagonal** (também conhecida como **Ports and Adapters**) combinada com práticas do **DDD** e da **Clean Architecture**, garantindo:

- 🧠 **Clareza semântica**: fica evidente o que é **entrada**, **saída**, **domínio** e **aplicação**.
- 🧱 **Separação de responsabilidades** bem delimitada.
- 🧪 **Facilidade de testes, manutenção e evolução** do sistema.

---

## ✅ Funcionalidades

- 📄 **Cadastrar uma nova pauta**
- 🕒 **Abrir uma sessão de votação** 
- 🗳️ **Receber votos** dos associados (Sim/Não)  
  - Cada associado é identificado por um ID único  
  - Cada associado pode votar **apenas uma vez por pauta**
- 📊 **Contabilizar os votos e retornar o resultado** de cada pauta

---

### 📂 Organização do Código

```plaintext
src/
├── application/        # Casos de uso da aplicação
├── domain/             # Entidades, enums, regras de negócio
├── infrastructure/     # Repositórios, integrações, controllers
└── config/             # Configurações gerais (CORS, Swagger, Beans)
```
---

## 🔗 Documentação da API

Após subir a aplicação, a documentação Swagger estará disponível em:

```
http://localhost:8080/swagger-ui.html
```

---

### 📌 Requisitos para rodar
- Java 17
- Maven 3.8+
- PostgreSQL 12+

---

### 📬 Contribuição
Sinta-se à vontade para abrir issues ou pull requests. Sugestões de melhoria e feedbacks são sempre bem-vindos!