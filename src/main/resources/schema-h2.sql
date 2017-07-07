DROP SCHEMA IF EXISTS cidades_brasil;
DROP TABLE IF EXISTS pais;
DROP TABLE IF EXISTS estado;
DROP TABLE IF EXISTS cidade;

CREATE SCHEMA cidades_brasil;

CREATE TABLE cidades_brasil.pais (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(60) DEFAULT NULL,
  sigla varchar(10) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE cidades_brasil.estado (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(75) DEFAULT NULL,
  uf varchar(5) DEFAULT NULL,
  pais int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pais) REFERENCES cidades_brasil.pais(id)
);

CREATE TABLE cidades_brasil.cidade (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(120) DEFAULT NULL,
  estado int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (estado) REFERENCES cidades_brasil.estado(id)
);