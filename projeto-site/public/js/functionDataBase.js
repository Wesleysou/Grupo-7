// ------ Memoria Total 
function getMemoriaRamTotal() {
    fetch("/usuarios/getMemoriaRamTotal").then(function (resposta) {
        console.log("ESTOU NO THEN DO getMemoriaRamTotal()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                ramTotal = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(ramTotal.RamTotalbd);
                sessionStorage.RAMTOTAL = ramTotal.RamTotalbd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
}

// Memoria Ram em uso 
function getMemoriaRamEmUso() {
    fetch("/usuarios/getMemoriaRamEmUso").then(function (resposta) {
        console.log("ESTOU NO THEN DO getMemoriaRamEmUso()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                ramEmuso = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(ramEmuso.RamEmUsobd);
                sessionStorage.RAMEMUSO = ramEmuso.RamEmUsobd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};
function getMemoriaRamEmUso() {
    fetch("/usuarios/getMemoriaRamEmUso").then(function (resposta) {
        console.log("ESTOU NO THEN DO getMemoriaRamEmUso()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                ramEmuso = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(ramEmuso.RamEmUsobd);
                sessionStorage.RAMEMUSO = ramEmuso.RamEmUsobd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};
function getMemoriaRamEmUso() {
    fetch("/usuarios/getMemoriaRamEmUso").then(function (resposta) {
        console.log("ESTOU NO THEN DO getMemoriaRamEmUso()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                ramEmuso = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(ramEmuso.RamEmUsobd);
                sessionStorage.RAMEMUSO = ramEmuso.RamEmUsobd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};


// Memoria  
function getMemoriaTotal() {
    fetch("/usuarios/getMemoriaTotal").then(function (resposta) {
        console.log("ESTOU NO THEN DO getMemoriaTotal()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                memoriaTotal = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(memoriaTotal.MemoriaTotalbd);
                sessionStorage.MEMORIATOTAL = memoriaTotal.MemoriaTotalbd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
}

// Memoria  
function getMemoriaEmUso() {
    fetch("/usuarios/getMemoriaEmUso").then(function (resposta) {
        console.log("ESTOU NO THEN DO getMemoriaEmUso()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                memoriaemuso = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(memoriaemuso.Memoriaemusobd);
                sessionStorage.MEMORIAEMUSO = memoriaemuso.Memoriaemusobd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};


// Sistema Op  
function getSistemaOp() {
    fetch("/usuarios/getSistemaOp").then(function (resposta) {
        console.log("ESTOU NO THEN DO getSistemaOp()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                sistemaop = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(sistemaop.Sistemaopbd);
                sessionStorage.SISTEMAOP = sistemaop.Sistemaopbd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};

// Processador 
function getProcessador() {
    fetch("/usuarios/getProcessador").then(function (resposta) {
        console.log("ESTOU NO THEN DO getProcessador()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                processador = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(processador.Processadorbd);
                sessionStorage.PROCESSADOR = processador.Processadorbd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};

// Arquitetura 
function getArquitetura() {
    fetch("/usuarios/getArquitetura").then(function (resposta) {
        console.log("ESTOU NO THEN DO getArquitetura()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                arquitetura = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(arquitetura.Arquiteturabd);
                sessionStorage.ARQUITETURA = arquitetura.Arquiteturabd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
};

// Cpu 
function getCpu() {
    fetch("/usuarios/getCpu").then(function (resposta) {
        console.log("ESTOU NO THEN DO getCpu()!")
        if (resposta.ok) {
            resposta.json().then(function (resposta) {
                console.log("Dados recebidos do usuario: ", JSON.stringify(resposta));

                cpu = resposta[resposta.indexOf(':') + 1]//não sei pq mas isso funciona
                console.log(cpu.Cpubd);
                sessionStorage.CPU = cpu.Cpubd;

            });
        } else {
            console.log("Dados recebidos: ", JSON.stringify(resposta));
        }
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;


};

