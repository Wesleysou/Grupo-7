create database Omniview;
use Omniview;

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
hostName VARCHAR(45),
email VARCHAR(45),
cpf VARCHAR(45),
senha VARCHAR(45),
cargo CHAR(1) CHECK(cargo = "S" or cargo = "G"),
Fk_EstUser INT,
FOREIGN KEY (Fk_EstUser) REFERENCES estabelecimento(id)
)AUTO_INCREMENT = 100;

SELECT * FROM usuario;

create table maquina(
id INT PRIMARY KEY AUTO_INCREMENT,
tipo VARCHAR(45),
sistemaOperacional VARCHAR(45),
ram DOUBLE(4,2),
arquitetura VARCHAR(45),
processador VARCHAR(50),
disco DOUBLE(4,2),
Fk_EstMaq INT,
FOREIGN KEY (Fk_EstMaq) REFERENCES estabelecimento (id)
)AUTO_INCREMENT = 500;

SELECT * FROM maquina;

create table medicoes(
id INT PRIMARY KEY AUTO_INCREMENT,
ram DOUBLE(4,2),
disco DOUBLE(4,2),
cpuM INT,
processo INT,
diaHorario DATETIME,
Fk_MaqRe INT,
FOREIGN KEY (Fk_MaqRe) REFERENCES maquina (id)
)AUTO_INCREMENT = 1000;