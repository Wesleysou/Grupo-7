/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;

import com.github.britooo.looca.api.core.Looca;

import java.util.List;

import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AutenticarLogin {

    Looca looca = new Looca();

    private String email;
    private String senha;
    private String id;

    public AutenticarLogin() {
    }

    public String getEmail() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List emailUsuariosBanco = con.queryForList("SELECT EMAIL FROM "
                + "USUARIOS WHERE ID=1");
        return emailUsuariosBanco.get(0).toString().replace("{EMAIL=", "").replace("}", "");
    }

    public String getSenha() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List senhaUsuariosBanco = con.queryForList("SELECT SENHA FROM "
                + "USUARIOS  WHERE ID=1");
        return senhaUsuariosBanco.get(0).toString().replace("{SENHA=", "").replace("}", "");
    }

    public String getId() {
        return this.id;
    }

    public AutenticarLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

    public static void CriarTabela() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        System.out.println("Criando tabela e inserindo dados...");
        con.execute("DROP TABLE IF EXISTS USUARIOS");
        con.execute("CREATE TABLE USUARIOS (ID INT"
                + " PRIMARY KEY AUTO_INCREMENT,"
                + " EMAIL VARCHAR(45), SENHA  VARCHAR(45)"
                + ", TIPO CHAR(1));");
        con.execute("INSERT INTO USUARIOS VALUES"
                + "(null, 'teste@email.com', 'teste', null);");

    }

    public String LoginId() {
        return "";
    }

    public static void AutenticarLogin(String email, String senha,
            String emailUsuarioBanco, String senhaUsuarioBanco) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List<User> usuario = con.query("SELECT EMAIL, SENHA FROM USUARIOS "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);
        List<User> usuarioId = con.query("SELECT ID FROM USUARIOS "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);
        if (usuario.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Acesso negado \n Usuário ou "
                    + "senha incorretos");
        } else {
            TelaOpcao tela = new TelaOpcao(usuarioId);
            tela.setVisible(true);

            JOptionPane.showMessageDialog(null, "Autenticado");

        }

    }

    public static void RegistrarCaixa(java.awt.event.ActionEvent evt,
            Boolean checkCaixa, String id) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        if (checkCaixa = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Caixa!");
            con.update("UPDATE USUARIOS SET TIPO='C' WHERE ID=?", id);

            List teste = con.queryForList("SELECT * FROM "
                    + "USUARIOS WHERE ID=?");
            System.out.println(teste);
            System.out.println("Caixa cadastrado");

        } else {
            System.out.println("caixa nao cadastrado");
        }
    }

    public static void RegistrarTotem(java.awt.event.ActionEvent evt,
            Boolean checkTotem) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        if (checkTotem = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Totem!");
            con.execute("UPDATE USUARIOS SET TIPO='T'  WHERE ID=?");

            List teste = con.queryForList("SELECT * FROM "
                    + "USUARIOS WHERE ID =?");

            teste.get(0).toString().replace("{EMAIL=", "").replace("}", "");
            System.out.println(teste);

            System.out.println("Totem cadastrado ");

        } else {
            System.out.println("totem nao cadastrado");
        }

    }

    public static void AbrirLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }

        });

    }
}
