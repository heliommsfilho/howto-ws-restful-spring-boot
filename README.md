* Soon: English Version

* [Versão em Português](https://github.com/heliomf-dev/howto-ws-restful-spring-boot/new/master?readme=1#pt-br-how-to-restful-web-service-with-spring-boot)

# [pt-BR] How To: RESTful Web Service com Spring Boot:

Este exemplo foi criado durante minhas práticas de como criar um *Web Service* RESTful utilizando *Spring Boot*. Durante o desenvolvimento erros foram encontrados e solucionados após várias pesquisas. Desta forma, este projeto acabou se tornando um modelo de como iniciar a criação de um *Web Service* com *Spring Boot* e evitar os mesmos erros.

Talvez este projeto possa servir para outras pessoas como repositório de exemplos para implementação de outros *Web Services* com *Spring Boot* ou como objeto de estudo. 

### Exemplos úteis presentes no projeto:

* *Deploy:*
  * Como configurar o projeto para executar em servidor *Tomcat* externo;
  
* Java:
  * Como criar classes que utilizam *Generics*;
  * Como criar testes unitários com *JUnit*.
  
* ModelMapper:
  * Uso do padrão *Data Transfer Object*;
  * Como utilizar o *ModelMapper* para criar *Data Transfer Objects* que serão entregues nas requisições;
  * Implementação de uma classe genérica personalizada **ListMapper** capaz de mapear um List arbitrário em um List de *Data Transfer Objects*.

* Banco de Dados:
  * Como criar entidades;
  * Como conectar ao *H2 Database* (implementação *Hibernate*);
  * Como tornar o *H2 Database* *case insensitive* em todos os Sistemas Operacionais.
  
* Spring JPA:
  * Como definir um *schema* padrão para a aplicação;
  * Como executar *scripts* SQL durante a inicialização do Spring Boot;
  * Criar repositórios que consultam o banco de dados através de *Query Methods*.

* Spring MVC:
  * Como criar Camada de Serviço para encapsular regras de negócio no padrão MVC;
  * Como criar *Controllers RESTful* que atendem via método GET e respondem utilizando *ResponseEntity*.

* Spring IoC:
  * Injeção simples de dependências com @Autowired.

### Como o projeto funciona:

O projeto consiste em um *Web Service* criado com *Spring Boot* capaz de recuperar informações armazenadas em um banco de dados embarcado *(H2 Database)*. Durante o *deploy* da aplicação dois *scripts* SQL serão executados automaticamente para criar e popular o banco de dados e dessa forma permitir que hajam dados presentes durante os testes. O **schema-h2.sql** contém o DDL para criar a estrutura inicial do banco de dados enquanto o **data-h2.sql** popula as tabelas.

**Importante:** Para evitar erros durante o *deploy*, inicie o servidor do *H2 Database* antes da aplicação.

Com o projeto em execução, o *Web Service* estará pronto para atender a requisições via método *GET*.

#### Instruções e mais informações consulte a [Wiki do projeto.](https://github.com/heliomf-dev/howto-ws-restful-spring-boot/wiki)
