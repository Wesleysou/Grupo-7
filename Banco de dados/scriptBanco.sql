create database Fastfood;
use Fastfood;
drop database Fastfood;

create table estabelecimento(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
cnpj VARCHAR(14),
endereco VARCHAR(45),
token VARCHAR(100) unique
);

SELECT * FROM estabelecimento;

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

SELECT * FROM usuario;

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

SELECT * FROM maquina;

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