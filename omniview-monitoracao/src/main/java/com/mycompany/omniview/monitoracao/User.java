/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro.h.tresmondi
 */
public class User {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());

    private String email;
    private String senha;

    public User() {
    }

    public User(Integer Id, String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    //StringBuilder createStatement = new StringBuilder();
    public String getEmail() {
        List emailUsuariosBanco = con.queryForList("SELECT EMAIL FROM "
                + "USUARIOS WHERE ID=1");
        return emailUsuariosBanco.get(0).toString().replace("{EMAIL=", "").replace("}", "");
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        List senhaUsuariosBanco = con.queryForList("SELECT SENHA FROM "
                + "USUARIOS  WHERE ID=1");
        return senhaUsuariosBanco.get(0).toString().replace("{SENHA=", "").replace("}", "");
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
