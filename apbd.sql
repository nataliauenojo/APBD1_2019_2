CREATE DATABASE  IF NOT EXISTS apbd;
USE apbd;


DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
  nome  varchar(45) NOT NULL,
  PRIMARY KEY (nome)
);

DROP TABLE IF EXISTS livros;
CREATE TABLE livros (
  isbn int(11) NOT NULL,
  titulo varchar(45) DEFAULT NULL,
  autor varchar(45) DEFAULT NULL,
  ano varchar(45) DEFAULT NULL,
  preco float DEFAULT NULL,
  categoria varchar(45) DEFAULT NULL,
  PRIMARY KEY (isbn),
  FOREIGN KEY (categoria) REFERENCES categoria (nome)
) ;

DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(45) DEFAULT NULL,
  telefone varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);