-- Arquivo de apoio, caso você queira criar tabelas como as aqui criadas para a API funcionar.
-- Você precisa executar os comandos no banco de dados para criar as tabelas,
-- ter este arquivo aqui não significa que a tabela em seu BD estará como abaixo!

/* para sql server - remoto - produção */

-- CREATE TABLE usuario (
-- 	id INT PRIMARY KEY IDENTITY(1,1),
-- 	nome VARCHAR(50),
-- 	email VARCHAR(50),
-- 	senha VARCHAR(50),
-- );

-- CREATE TABLE aviso (
-- 	id INT PRIMARY KEY IDENTITY(1,1),
-- 	titulo VARCHAR(100),
--     descricao VARCHAR(150),
-- 	fk_usuario INT FOREIGN KEY REFERENCES usuario(id)
-- ); 

-- CREATE TABLE medida (
-- 	id INT PRIMARY KEY IDENTITY(1,1),
-- 	temperatura DECIMAL,
-- 	umidade DECIMAL,
-- 	momento DATETIME,
-- 	fk_aquario INT
-- );


/* para workbench - local - desenvolvimento */
-- CREATE DATABASE acquatec;

-- USE acquatec;

-- CREATE TABLE usuario (
-- 	id INT PRIMARY KEY AUTO_INCREMENT,
-- 	nome VARCHAR(50),
-- 	email VARCHAR(50),
-- 	senha VARCHAR(50)
-- );

-- CREATE TABLE aviso (
-- 	id INT PRIMARY KEY AUTO_INCREMENT,
-- 	titulo VARCHAR(100),
--     descricao VARCHAR(150),
-- 	fk_usuario INT,
-- 	FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
-- ); 

-- CREATE TABLE medida (
-- 	id INT PRIMARY KEY AUTO_INCREMENT,
-- 	temperatura DECIMAL,
-- 	umidade DECIMAL,
-- 	momento DATETIME,
-- 	fk_aquario INT
-- );

create database Fastfood;
use Fastfood;

create table estabelecimento(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
cnpj VARCHAR(14),
endereco VARCHAR(45),
token VARCHAR(100) unique
);


create table usuario(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(45),
senha VARCHAR(45),
comfirmSenha VARCHAR(45),
tipo CHAR(1) CHECK(tipo = "S" or tipo = "G"),
Fk_EstUser INT,
FOREIGN KEY (Fk_EstUser) REFERENCES estabelecimento(id)
)AUTO_INCREMENT = 100;

select * from usuario;

create table maquina(
id INT PRIMARY KEY AUTO_INCREMENT,
tipo VARCHAR(45),
sistemaOperacional VARCHAR(45),
ram VARCHAR(45),
arquitetura VARCHAR(45),
processador VARCHAR(50),
disco VARCHAR(50),
Fk_EstMaq INT,
FOREIGN KEY (Fk_EstMaq) REFERENCES estabelecimento (id)
)AUTO_INCREMENT = 500;


create table recursos(
idRe INT PRIMARY KEY AUTO_INCREMENT,
ramRe INT,
disco INT,
cpuRe INT,
processo INT,
horarioRE TIME,
diaRe DATE,
Fk_MaqRe INT,
FOREIGN KEY (Fk_MaqRe) REFERENCES maquina (id)
)AUTO_INCREMENT = 1000;