# MVC Desafio

<div style="display: inline-block">
  <img align="center" alt="Java-Logo" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
  <img align="center" alt="Spring-Logo" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
  <img align="center" alt="Postgres-Logo" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg">
</div><br>

In our application, you can seamlessly manage project-related tasks and enhance collaboration by utilizing CRUD operations on the "Projects" table and adding new members to projects through our web service... It was made using Java, Spring MVC, PostgreSQL and JSP.

## Pre-Configuration

This project persists the relevant data using PostgreSQL. To successfully build it, you have to create the databaseDesafio database and the tables.

Assuming that you have PostgreSQL properly installed and configured on your machine, simple run the following commands in your terminal (recommended) or in a database management system of your choice (you would have to make some adjustments).

**1) Run PostgreSQL**
* For Linux users:
```
sudo -u postgres psql
```
* For Windows users:
```
psql -U postgres
```
**2) Create the database:**
```sql
CREATE DATABASE databaseDesafio;
```
**3) Connect to it:**
```
\c dataBase
```
**4) Create the database tables:**
* **OBS**: CPF is the unique identifier of brazilian citizens. It's like the SSN used in the United States.
```sql
CREATE TABLE pessoa
( id bigserial NOT NULL,
nome character varying(100) NOT NULL,
datanascimento date,
cpf character varying(14),
funcionario boolean,
gerente boolean,
CONSTRAINT pk_pessoa PRIMARY KEY (id));

CREATE TABLE  projeto (
  id bigserial NOT NULL,
  nome VARCHAR(200) NOT NULL,
  data_inicio DATE ,
  data_previsao_fim DATE ,
  data_fim DATE ,
  descricao VARCHAR(5000) ,
  status VARCHAR(45) ,
  orcamento FLOAT ,
  risco VARCHAR(45) ,
  idgerente bigint NOT NULL,
  CONSTRAINT pk_projeto PRIMARY KEY (id),
  CONSTRAINT fk_gerente FOREIGN KEY (idgerente)
  REFERENCES pessoa (id) MATCH SIMPLE
 ON UPDATE NO ACTION ON DELETE NO ACTION)

-- -----------------------------------------------------
-- Table Membros
-- -----------------------------------------------------
CREATE TABLE membros
( idprojeto bigint NOT NULL, 
idpessoa bigint NOT NULL,  
CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto),
CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa)
REFERENCES projeto (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa)
REFERENCES pessoa (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION);

``` 

**OBS**: After that, you have to configure the database connection on your IDE. If you're using Intellij IDEA, just [follow these steps](https://www.jetbrains.com/help/idea/configuring-database-connections.html). If you're using Eclipse or Netbeans, [follow these ones](https://www.enterprisedb.com/postgres-tutorials/how-connect-postgres-database-using-eclipse-and-netbeans).

## Application Features: CRUD Operations on Projects
In our application, you have the ability to perform CRUD operations on the "Projects" table. CRUD stands for Create, Read, Update, and Delete – essential actions for managing project data efficiently.

```sql
INSERT INTO pessoa (nome, datanascimento, cpf, funcionario, gerente) VALUES
('João Silva', '1990-01-15', '123.456.789-01', true, false),
('Maria Oliveira', '1985-05-20', '987.654.321-00', true, true),
('Carlos Santos', '1995-08-10', '555.888.777-22', true, false);

-- Inserir dados na tabela Projeto
INSERT INTO projeto (nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco, idgerente) VALUES
('Projeto A', '2022-02-01', '2022-06-30', NULL, 'Descrição do Projeto A', 'Em Andamento', 50000.00, 'Baixo', 2),
('Projeto B', '2022-03-15', '2022-08-31', NULL, 'Descrição do Projeto B', 'Planejado', 75000.00, 'Médio', 1),
('Projeto C', '2022-01-10', '2022-04-30', '2022-06-15', 'Descrição do Projeto C', 'Concluído', 30000.00, 'Alto', 3);
```
## API Endpoint for Inserting a New Pessoa

### Endpoint

- **Method:** POST
- **URL:** `/api/pessoas`
  
### Request

- **Body:** JSON object representing the data of the new Pessoa.
  
Example:
```json
{
  "nome": "John Doe",
  "datanascimento": "1990-05-15",
  "cpf": "123.456.789-01",
  "funcionario": true,
  "gerente": false
}
```
- ```Status Code:** 200 OK.```
**Body:** JSON object representing the newly inserted Pessoa.

You're ready to run the project and enjoy it!

