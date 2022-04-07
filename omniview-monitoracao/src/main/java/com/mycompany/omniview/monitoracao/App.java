/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;

import com.github.britooo.looca.api.core.Looca;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        StringBuilder createStatement = new StringBuilder();
        Looca looca = new Looca();

        


        // Usuario usuario1 = new Usuario(01, "teste@email.com", "teste");
        System.out.println("Criando tabela e inserindo dados...");
        createStatement.append("DROP TABLE IF EXISTS USUARIOS");
        createStatement.append("CREATE TABLE USUARIOS (ID INT"
                + " PRIMARY KEY AUTO_INCREMENT,"
                + " EMAIL VARCHAR(45), SENHA  VARCHAR(45)"
                + ", TIPO CHAR(1));");
        createStatement.append("INSERT INTO USUARIOS VALUES"
                + "(null, 'teste@email.com', 'teste', null);");

       

    }
}
