CREATE DATABASE checkout_beatriz
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

USE CHECKOUT

CREATE TABLE produto (
  id int(4) AUTO_INCREMENT,
  descricao varchar,
  valor numeric,
  promocao int
  PRIMARY KEY (id)
);

CREATE TABLE promocao (
  id int(4) AUTO_INCREMENT,
  descricao varchar,
  observação varchar,
  qtde_ativacao int,
  preco_final numeric ,
  qtd_paga numeric
  PRIMARY KEY (id)
);

CREATE TABLE compra (
  codigo int(4) AUTO_INCREMENT,
  total numeric,
  totalDescont numeric
  PRIMARY KEY (codigo)
);

INSERT INTO produto(codigo, nome, valor) VALUES (null, “A”, “30”) ;
INSERT INTO produto(codigo, nome, valor) VALUES (null, “B”, “50”) ;
INSERT INTO produto(codigo, nome, valor) VALUES (null, “C”, “20”) ;

SELECT * FROM produto;

DELETE FROM produto WHERE codigo=3
