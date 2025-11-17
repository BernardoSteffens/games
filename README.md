# 🎮 GameHub API

API desenvolvida para a disciplina de **Desenvolvimento Web** da **Universidade Estadual de Ponta Grossa (UEPG)**. O objetivo do projeto é fornecer uma API REST para gerenciar jogos, permitindo criar, listar, filtrar, atualizar e remover registros.

---

## 📘 Sumário

* [Sobre o Projeto](#-sobre-o-projeto)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Como Executar o Projeto](#-como-executar-o-projeto)
* [Endpoints da API](#-endpoints-da-api)
* [Exemplos de Requisições](#-exemplos-de-requisições)
* [Autores](#-autores)

---

## 📌 Sobre o Projeto

A **GameHub API** é uma aplicação REST desenvolvida com Spring Boot para gerenciar uma coleção de jogos. A API permite:

* Registrar novos jogos
* Listar jogos com filtros e ordenações
* Atualizar informações de jogos existentes
* Excluir jogos pelo ID

Além disso, oferece suporte a filtros por **gênero**, **plataforma**, **nome** e ordenação por **rating** ou **nome**.

---

## 🛠 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot** (Web, Validation, JPA)
* **Banco de Dados**: H2 ou PostgreSQL
* **Maven**

---

## 🚀 Como Executar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seu-repositorio/gamehub-api.git
cd gamehub-api
```

### 2️⃣ Executar com Maven

```bash
mvn spring-boot:run
```

### 3️⃣ Acessar a API

```
http://localhost:8080/games
```

Se estiver usando o console do H2:

```
http://localhost:8080/h2-console
```

---

## 📡 Endpoints da API

| **Método** | **Endpoint**  | **Descrição**                                                                                                                                                                   | **Códigos HTTP**                                                          |
| ---------- | ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| **GET**    | `/games`      | Lista todos os jogos com possibilidade de filtros (`?genero=`, `?plataforma=`, `?nome=`) e ordenações (`?ordenarPorNomeDesc`, `?ordenarPorRatingAsc`, `?ordenarPorRatingDesc`). | `200 OK`, `204 NO CONTENT`, `500 INTERNAL SERVER ERROR`                   |
| **POST**   | `/games`      | Cria um novo jogo com validação de dados.                                                                                                                                       | `201 CREATED`, `400 BAD REQUEST`, `500 INTERNAL SERVER ERROR`             |
| **PUT**    | `/games/{id}` | Atualiza os dados de um jogo existente.                                                                                                                                         | `200 OK`, `400 BAD REQUEST`, `404 NOT FOUND`, `500 INTERNAL SERVER ERROR` |
| **DELETE** | `/games/{id}` | Remove um jogo pelo ID.                                                                                                                                                         | `204 NO CONTENT`, `404 NOT FOUND`, `500 INTERNAL SERVER ERROR`            |

---

## 📝 Exemplos de Requisições

### ➕ Criar um jogo (POST `/games`)

```json
{
  "nome": "The Witcher 3",
  "genero": "RPG",
  "plataforma": "PC",
  "rating": 9.5
}
```

### 🔍 Listar com filtros (GET `/games?genero=RPG&ordenarPorRatingDesc`)

Retorna todos os jogos do gênero *RPG*, ordenados por rating decrescente.

### ✏️ Atualizar jogo (PUT `/games/1`)

```json
{
  "nome": "The Witcher 3: Wild Hunt",
  "rating": 9.7
}
```

### ❌ Deletar jogo (DELETE `/games/1`)

Sem corpo na requisição.

---

## 👥 Autores

* **Bernardo de Macedo Steffens**
* **Luis Gustavo Vieira Carneiro**
* **Vinicius Denega D'Alves**

---

Se quiser, posso também gerar **badges**, adicionar uma **licença**, criar uma **estrutura de pastas**, ou gerar um README ainda mais completo.
