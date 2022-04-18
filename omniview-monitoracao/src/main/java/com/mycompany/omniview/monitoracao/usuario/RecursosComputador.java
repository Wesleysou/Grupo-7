/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.monitoracao.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mariana.cazzoto
 */
public class RecursosComputador {

    private String processador;
    private Integer bitMaquina;
    private String sistemaOperacional;
    private Double disco;
    private Integer arquiteturaSis;
    private Double memoriaRam;

    Looca looca = new Looca();

    public void informacoesDoSistema() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        
        
        //Pega o nome do processador
        processador = looca.getProcessador().getNome();

        //Pega quantos bit a maquina tem
        bitMaquina = looca.getSistema().getArquitetura();

        //Pega o sistema operacional da maquina
        sistemaOperacional = looca.getSistema().getSistemaOperacional();

        //Total de Disco
        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        disco = discoByte / 1073741824.0;

        arquiteturaSis = looca.getSistema().getArquitetura();
        
        Long memoriaRamByte = looca.getMemoria().getEmUso();
        memoriaRam = memoriaRamByte/1073741824.0;
        
        con.update("INSERT INTO MAQUINA VALUES (null, null, ?,?,?,?,?,null)",
                sistemaOperacional,memoriaRam,
                arquiteturaSis,processador,disco);

    }

    public void informacaomemoria() {
        //Pega as informações da memoria a cada 5 segundos
        while (true) {

            // try = tentar , se der erro vai pro catch
            // thread = tarefas 
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TesteRecursos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(looca.getMemoria());
        }
    }

    @Override
    public String toString() {
        return String.format("Processador: %s \n"
                + "Total de bits: %d \n"
                + "Sistema Operacional: %s \n"
                + "Total Disco: %.2fGB \n"
                + "Arquitetura do sistema: %dx "
                + "\n"
                + "-------Memória-------", processador, bitMaquina,
                sistemaOperacional,
                disco, arquiteturaSis, looca.getMemoria());
    }

}
