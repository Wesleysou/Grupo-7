/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview;

import java.net.InetAddress;
import metodos.AutenticarLogin;
import metodos.ConsultaBanco;
import metodos.MedicoesComputador;
import metodos.RecursosComputador;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro
 */
public class OmniviewApp {

    public static void main(String[] args) {
        Connection config = new Connection();

        metodos.AutenticarLogin.AbrirLogin();
        metodos.RecursosComputador reqMaq = new RecursosComputador();
        metodos.MedicoesComputador medMaq = new MedicoesComputador();
        metodos.ConsultaBanco cntsBanco = new ConsultaBanco();
        
        System.out.println(reqMaq.getHostname());
        
        System.out.println(cntsBanco.getIDMaquina());
       
     
      
    }

}
