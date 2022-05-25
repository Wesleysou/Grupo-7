var database = require("../database/config")

var idMaquinaBanco;


function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM usuario;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM usuario WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrar(nome, email, cpf, senha, cargo, estabelecimento) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nome, email, cpf, senha, cargo, estabelecimento);
    var instrucao = `
        INSERT INTO usuario VALUES ('${nome}', '${email}', '${cpf}', '${senha}', '${cargo}','${estabelecimento}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// =================================== MEMORIA TOTAL MAQUINA 1 =====================================
function getMemoriaRamTotal() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamTotal()");
    var instrucao = `
    select ramTotal as RamTotalbd from [dbo].[maquina] where id = 506; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// ================================== MEMORIA TOTAL MAQUINA 2 ==================================
function getMemoriaRamTotalTot2() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamTotalTot2()");
    var instrucao = `
    select ramTotal as RamTotalbd from [dbo].[maquina] where id = 506; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// ================================== MEMORIA TOTAL MAQUINA 3 ==================================
function getMemoriaRamTotalTot3() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamTotalTot3()");
    var instrucao = `
    select ramTotal as RamTotalbd from [dbo].[maquina] where id = 506; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// ================================== MEMORIA TOTAL MAQUINA 4 ==================================
function getMemoriaRamTotalTot4() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamTotalTot4()");
    var instrucao = `
    select ramTotal as RamTotalbd from [dbo].[maquina] where id = 506; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// ================================== MEMORIA TOTAL MAQUINA 5 ==================================
function getMemoriaRamTotalTot5() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamTotalTot5()");
    var instrucao = `
    select ramTotal as RamTotalbd from [dbo].[maquina] where id = 506; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// -------------------------------------------- RAM TOTEM 1 -------------------------------------
function getMemoriaRamEmUso() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamEmUso()");
    var instrucao = `
    select top 1 ram as RamEmUsobd from [dbo].[medicoes] where Fk_MaqRe = 506 order by diaHorario desc; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
// ==================================================================================================

// -------------------------------------------- RAM TOTEM 2 -------------------------------------
function getMemoriaRamEmUsoTot2() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamEmUsoTot2()");
    var instrucao = `
    select top 1 ram as RamEmUsobd from [dbo].[medicoes] where Fk_MaqRe = 506 order by diaHorario desc; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
// ==============================================================================================

// -------------------------------------------- RAM TOTEM 3 -------------------------------------
function getMemoriaRamEmUsoTot3() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamEmUsoTot3()");
    var instrucao = `
    select top 1 ram as RamEmUsobd from [dbo].[medicoes] where Fk_MaqRe = 506 order by diaHorario desc; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
// =================================================================================================

// -------------------------------------------- RAM TOTEM 4 -------------------------------------
function getMemoriaRamEmUsoTot4() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamEmUsoTot4()");
    var instrucao = `
    select top 1 ram as RamEmUsobd from [dbo].[medicoes] where Fk_MaqRe = 506 order by diaHorario desc; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
// =================================================================================================

// -------------------------------------------- RAM TOTEM 5 -------------------------------------
function getMemoriaRamEmUsoTot5() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaRamEmUsoTot5()");
    var instrucao = `
    select top 1 ram as RamEmUsobd5 from [dbo].[medicoes] where Fk_MaqRe = 506 order by diaHorario desc; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
// =================================================================================================

function getMemoriaTotal() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaTotal()");
    var instrucao = `
    select disco as MemoriaTotalbd from [dbo].[maquina] where id = 506 ; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function getMemoriaEmUso() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getMemoriaEmUso()");
    var instrucao = `
    select top 1 usoDoDisco as Memoriaemusobd from [dbo].[medicoes] where Fk_MaqRe = 506 order by diaHorario desc;`
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function getSistemaOp() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getSistemaOp()");
    var instrucao = `
    select sistemaOperacional as Sistemaopbd from [dbo].[maquina] where id = 506 
    ;`
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function getProcessador() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getProcessador()");
    var instrucao = `
    select processador as Processadorbd from [dbo].[maquina] where id = 506;`
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function getArquitetura() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getArquitetura()");
    var instrucao = `
    select arquitetura as Arquiteturabd from [dbo].[maquina] where id = 506; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function getCpu() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function getCpu()");
    var instrucao = `
    select top 1 cpuM as Cpubd from [dbo].[medicoes] where Fk_MaqRe = 506 `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// ---------------------------- Desativar funcionario -----------------------------------------
function altearStatusColaborador(novaDescricao, idAviso) {
    console.log("ACESSEI O AVISO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function altearStatusColaborador(): ", novaDescricao, idAviso);
    var instrucao = `
        UPDATE aviso SET descricao = '${novaDescricao}' WHERE id = ${idAviso};
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function reiniciarmaq(
    reiniciarMaq
  ) {
    var instrucao = `
    update [dbo].[maquina] set reiniciar = ${reiniciarMaq} where id = 
(
    SELECT TOP 1 id
    FROM [dbo].[maquina]
	ORDER BY id DESC
);
      `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
  }

module.exports = {
    entrar,
    cadastrar,
    listar,
    reiniciarmaq,
    getMemoriaRamTotal,
    getMemoriaRamEmUso,
    getMemoriaEmUso,
    getMemoriaTotal,
    getSistemaOp,
    getProcessador,
    getArquitetura,
    getCpu,
    getMemoriaRamEmUsoTot2,
    getMemoriaRamEmUsoTot3,
    getMemoriaRamEmUsoTot4,
    getMemoriaRamEmUsoTot5,
    getMemoriaRamTotalTot2,
    getMemoriaRamTotalTot3,
    getMemoriaRamTotalTot4,
    getMemoriaRamTotalTot5,
};