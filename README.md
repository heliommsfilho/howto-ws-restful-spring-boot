[Read in English](https://github.com/heliomf-dev/howto-ws-restful-spring-boot#english-how-to-restful-web-service-with-spring-boot) ou [leia em Português](https://github.com/heliomf-dev/howto-ws-restful-spring-boot#portuguese-how-to-restful-web-service-com-spring-boot)

# [English] How To: RESTful Web Service with Spring Boot:

This example was created during my studies of Web Service RESTful using Spring Boot. In development's phase, errors were found and solved after several researches. By this way, the project became a model of how to start the creation of a Web Service with Spring Boot and avoid the same errors.

Maybe this project can serve like repository of examples to implement others Spring Boot Web Services or like study case.

### Userful examples into the project:

* Deployment:
  * How to configure the project to run in a external Tomcat server;
  
* Java:
  * How to create classes using *Generics*;
  * How to create unit tests with *JUnit*.
  
* ModelMapper:
  * Usage of *Data Transfer Objects*;
  * How to use `ModelMapper` to create *Data Transfer Objects* which will be delivered into requests;
  * Implementation of a custom generic class `ListMapper` capable to map a arbitrary `List<?>` into a `List<?>` of *Data Transfer Objects*.

* Database:
  * How to create entities;
  * How to connect a *H2 Database* (*Hibernate's* Implementation);
  * How to turn *H2 Database* case insensitive in all Operating Systems.
  
* Spring JPA:
  * How to define a default schema for application;
  * How to execute SQL scripts during Spring Boot startup;
  * How to create repositories which consult the database through *Query Methods*.

* Spring MVC:
  * How to create Service layer to encapsulate business logic in MVC pattern;
  * How to create RESTful Controllers which listen via GET method and respond using `ResponseEntity`.

* Spring IoC:
  * Simple dependency injection with `@Autowired`.

### How project works:

The project consists in a Web Service created with Spring Boot capable to retrieve information stored in a embedded *H2 Database*. While deploying the application, two SQL scripts will be executed automatically to create and populate the database. The `schema-h2.sql` contais DDL to create initial database's structure while `data-h2.sql` fullfil tables.

### Instructions:

1. Startup *H2 Database* server with command: `java -jar h2-{your-version}.jar`
2. Deploy the application in Tomcat 8 (or higher) running over Java 8 (or higher)

### Available services:

* Query Countries:
  * http://localhost:8080/spring_rest_server/country/all
    > Load all Countries

  * http://localhost:8080/spring_rest_server/country/abbreviation/{abbreviation}
    > Country with abbreviation `{abbreviation}`

  * http://localhost:8080/spring_rest_server/country/name/{countryName}
    > Countries which name contains `{countryName}`
    
* Query States:
  * http://localhost:8080/spring_rest_server/state/all
    > Load all States

  * http://localhost:8080/spring_rest_server/state/abbreviation/{abbreviation}
    > State with abbreviation `{abbreviation}`

  * http://localhost:8080/spring_rest_server/state/name/{stateName}
    > States which name contains `{stateName}`
    
* Query Cities:
  * http://localhost:8080/spring_rest_server/city/all
    > Load all Cities

  * http://localhost:8080/spring_rest_server/city/state/{abbreviation}
    > Cities which belongs to State with abbreviation `{abbreviation}`

  * http://localhost:8080/spring_rest_server/city/name/{cityName}
    > Cities which name contains `{cityName}`
    
***

# [Portuguese] How To: RESTful Web Service com Spring Boot:

Este exemplo foi criado durante meus estudos de *Web Service* RESTful utilizando *Spring Boot*. Na fase de desenvolvimento erros foram encontrados e solucionados após várias pesquisas. Desta forma, o projeto acabou se tornando um modelo de como iniciar a criação de um *Web Service* com *Spring Boot* e evitar os mesmos erros.

Talvez este projeto possa servir como repositório de exemplos para implementação de outros *Web Services* com *Spring Boot* ou como caso de estudo. 

### Exemplos úteis presentes no projeto:

* *Deployment:*
  * Como configurar o projeto para executar em servidor *Tomcat* externo;
  
* Java:
  * Como criar classes que utilizam *Generics*;
  * Como criar testes unitários com *JUnit*.
  
* ModelMapper:
  * Uso de *Data Transfer Objects*;
  * Como utilizar *ModelMapper* para criar *Data Transfer Objects* que serão entregues nas requisições;
  * Implementação de uma classe genérica personalizada `ListMapper` capaz de mapear um `List<?>` arbitrário em `List<?>` de *Data Transfer Objects*.

* Banco de Dados:
  * Como criar entidades;
  * Como conectar ao *H2 Database* (implementação *Hibernate*);
  * Como tornar o *H2 Database* *case insensitive* em todos os Sistemas Operacionais.
  
* Spring JPA:
  * Como definir um *schema* padrão para a aplicação;
  * Como executar *scripts* SQL durante a inicialização do Spring Boot;
  * Como criar repositórios que consultam o banco de dados através de *Query Methods*.

* Spring MVC:
  * Como criar camada de Serviço para encapsular regras de negócio no padrão MVC;
  * Como criar *Controllers RESTful* que atendem via método GET e respondem utilizando `ResponseEntity`.

* Spring IoC:
  * Injeção simples de dependências com `@Autowired`.

### Como o projeto funciona:

O projeto consiste em um *Web Service* criado com *Spring Boot* capaz de recuperar informações armazenadas em um banco de dados embarcado *H2 Database*. Durante o *deploy* da aplicação, dois *scripts* SQL serão executados automaticamente para criar e popular o banco de dados. O `schema-h2.sql` contém o DDL para criar a estrutura inicial do banco de dados enquanto o `data-h2.sql` popula as tabelas.

### Instruções:

1. Iniciar o servidor do *H2 Database* com o comando: `java -jar h2-xxx.jar`
2. Realizar o *deploy* da aplicação no servidor Tomcat 8 (ou superior) executando sobre Java 8 (ou superior)

### Serviços disponíveis:

* Consultar Países:
  * http://localhost:8080/spring_rest_server/country/all
    > Todos os Países

  * http://localhost:8080/spring_rest_server/country/abbreviation/{siglaPais}
    > País com a sigla `{siglaPais}`

  * http://localhost:8080/spring_rest_server/country/name/{nomePais}
    > Países cujo nome contém `{nomePais}`
    
* Consultar Estados:
  * http://localhost:8080/spring_rest_server/state/all
    > Todos os Estados

  * http://localhost:8080/spring_rest_server/state/abbreviation/{siglaEstado}
    > Estado com a sigla `{siglaEstado}`

  * http://localhost:8080/spring_rest_server/state/name/{nomeEstado}
    > Estado cujo nome contém `{nomeEstado}`
    
* Consultar Cidades:
  * http://localhost:8080/spring_rest_server/city/all
    > Todos as Cidades

  * http://localhost:8080/spring_rest_server/city/state/{siglaEstado}
    > Cidades que pertencem ao Estado com a sigla `{siglaEstado}`

  * http://localhost:8080/spring_rest_server/city/name/{nomeCidade}
    > Cidades cujo nome contém `{nomeCidade}`
