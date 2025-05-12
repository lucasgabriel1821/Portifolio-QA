CREATE DATABASE banco_teste_automacao;
USE banco_teste_automacao;
CREATE TABLE usuarios (
	id VARCHAR(20) PRIMARY KEY,
	name VARCHAR(100),
	email VARCHAR(100),
	username VARCHAR(50),
	password VARCHAR(50)
);
SELECT * FROM USUARIOS;

ALTER TABLE usuarios CHANGE name nome VARCHAR(100);

ALTER TABLE usuarios CHANGE password Password VARCHAR(100);