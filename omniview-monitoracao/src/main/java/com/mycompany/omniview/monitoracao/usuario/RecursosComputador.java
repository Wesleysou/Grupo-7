/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao.usuario;

import com.github.britooo.looca.api.core.Looca;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariana.cazzoto
 */
public class RecursosComputador {
    
    private String processador;
    private Integer bitMaquina;
    private String sistemaOperacional;
    private Long disco;
    private

    Looca looca = new Looca();
    
    public void informacoesDoSistema(){
        //Pega o nome do processador
        processador = looca.getProcessador().getNome();
        
        //Pega quantos bit a maquina tem
        bitMaquina = looca.getSistema().getArquitetura();
        
        //Pega o sistema operacional da maquina
        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        
        //Total de Disco
        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        Long discoKiloByte = discoByte / 1024;
        Long discoMegaByte = discoKiloByte / 1024;
        disco = discoMegaByte / 1024;
    }

    public void informacaomemoria(){
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
        return  String.format("Processador: %s \n" +
                "Total de bits: %d \n" +
                "Sistema Operacional: %s \n" +
                "Total Disco: %dGB \n" +
                "-------Memória-------",processador, bitMaquina, sistemaOperacional,disco,looca.getMemoria());
    }
    
}
