create database Fastfood;
use Fastfood;
drop database Fastfood;

create table tb_estabelecimento(
idEst INT PRIMARY KEY AUTO_INCREMENT,
nomeEst VARCHAR(50),
cnpjEst VARCHAR(14),
enderecoEst VARCHAR(45)
);

INSERT INTO tb_estabelecimento VALUES
(null,"MacsFree",12345678909876,"Rua Haddock Lobo Nº100");

SELECT * FROM tb_estabelecimento;

create table tb_usuario(
idUser INT PRIMARY KEY AUTO_INCREMENT,
nomeUser VARCHAR(45),
emailUser VARCHAR(45),
cpfUser VARCHAR(45),
rgUser VARCHAR(45),
senhaUser VARCHAR(45),
comfirmSenhaUser VARCHAR(45),
tipoUser CHAR(1) CHECK(tipoUser = "S" or tipoUser = "G"),
Fk_EstUser INT,
FOREIGN KEY (Fk_EstUser) REFERENCES tb_estabelecimento(idEst)
)AUTO_INCREMENT = 100;

INSERT INTO tb_usuario VALUES
(null,"Wesley","wesley@gmail.com","84930293","222344332","Wesley123","Wesley123","S",1);

SELECT * FROM tb_usuario;

create table tb_maquina(
idMaq INT PRIMARY KEY AUTO_INCREMENT,
tipoMaq VARCHAR(45),
marcaMaq VARCHAR(45),
soMaq VARCHAR(45),
ramMaq VARCHAR(45),
setorMaq VARCHAR(45),
Fk_EstMaq INT,
FOREIGN KEY (Fk_EstMaq) REFERENCES tb_estabelecimento (idEst)
)AUTO_INCREMENT = 500;

INSERT INTO tb_maquina VALUES
(null,"Toten","Samsung","Windows","20GB","Alimentação",1);
SELECT * FROM tb_maquina;

create table tb_recursos(
idRe INT PRIMARY KEY AUTO_INCREMENT,
ramRe INT,
memoria INT,
cpuRe INT,
horarioRE TIME,
diaRe DATE,
Fk_MaqRe INT,
FOREIGN KEY (Fk_MaqRe) REFERENCES tb_maquina (idMaq)
)AUTO_INCREMENT = 1000;

INSERT INTO tb_recursos VALUES
(null,80,30,60,'14:00:00','2021-02-02',500),
(null,40,30,60,'14:10:00','2021-02-02',500);

SELECT * FROM tb_recursos;

-- Select que mostra a Maquina o setor que ela está localizada, ram que está sendo utilizada.
SELECT idMaq as Maquina,tipoMaq as Tipo,marcaMaq as Marca,setorMaq as Localização,ramRe as "Memoria Ram",horarioRe as Hora,diaRe as "Data" FROM tb_maquina 
INNER JOIN tb_recursos
ON tb_recursos.Fk_MaqRe = tb_maquina.idMaq;


drop table tb_recursos;
drop table tb_maquina;