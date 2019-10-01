# Desafio tecnico -  SAS

Neste repositório contém uma **API REST** que gerencia o desempenho de alunos baseado nas notas de um simulado. É considerado neste projeto um modelo de banco relacional que nos trás: Alunos, Classificação e Simulados.

![enter image description here](https://lh3.googleusercontent.com/YHaw-ltQ_jMDKGQcjlDvOf5X4CEQY-YW-GeyrWVgcbakU-kaJ0R7rtliEEcrTeK1dS9M0AaH8sGt=s300 "Java 11")

![
](https://lh3.googleusercontent.com/LQcYRBimAJ9j4MTQR8f4FLtF99P3qXz3LAahr6ud2eePS_F-yklEtHE54WtvIppnNWN0id7T0yDG=s300 "Spring Mysql")

## Descrição Técnica da API
O projeto aqui alocado foi desenvolvido utilizando Java 11, Maven, Spring boot, Spring Data, Lombook, banco relacional Mysql, Migration (versionamento de banco de dados) e JUnit.

## Execução da API

Na pasta raiz, deve-se abrir um terminal e executar o seguinte comando : **mvn spring-boot:run**

## Execução dos Teste Unitários

Na pasta raiz, deve-se abrir um terminal e executar o seguinte comando : **mvn test**

## Testes de execução

Na pasta raiz, localizar pasta "collection-postman", onde temos uma coleção utilizando a ferramenta *postman* com exemplos das principais funcionalidades da API.

## Principais recursos da aplicação

Fora os recursos aqui descritos, todos os modelos deste projeto (Aluno, Classificação, Prova, Questão e Simulado) possuem recursos CRUD básicos.

 - Salvar prova: POST - http://localhost:8080/provas
 - Resolver prova  POST - http://localhost:8080/provas/resolver-prova
 - Gabarito da prova: GET - http://localhost:8080/provas/**id**/gabarito
 - Classificação do simulado: GET- http://localhost:8080/classificacoes/simulado/**idSimulado**
 - Trazer questão para resolver : GET - http://localhost:8080/questoes/**id**/resolver-questao
 - Resolver questão : POST - http://localhost:8080/questoes/**id**/resolver-questao
 - Trazer provas do simulado : GET - http://localhost:8080/simulados/**id**/provas
