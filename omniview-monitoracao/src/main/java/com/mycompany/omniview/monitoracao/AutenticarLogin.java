/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.omniview.monitoracao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.smartcardio.CardTerminal;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

public class AutenticarLogin {

    public String email;
    public String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public AutenticarLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public static void AutenticarLogin(String email, String senha,
            String emailUsuarioBanco, String senhaUsuarioBanco) {
        if (email.equals(emailUsuarioBanco) && senha.equals(senhaUsuarioBanco)) {

            JOptionPane.showMessageDialog(null, "Login realizado com sucesso");

            TelaOpcao tela = new TelaOpcao();
            tela.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado \n Usuário ou "
                    + "senha incorretos");

        }
    }

    public static void RegistrarCaixa(java.awt.event.ActionEvent evt,
            Boolean checkCaixa) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        if (checkCaixa = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Caixa!");
            con.execute("UPDATE USUARIOS SET TIPO='C'  WHERE ID=1;");

            List teste = con.queryForList("SELECT * FROM "
                    + "USUARIOS");
            System.out.println(teste);
            System.out.println("Caixa cadastrado");

        } else {
            System.out.println("caixa nao cadastrado");
        }

        /*JOptionPane.showMessageDialog(null, "Você cadastrou um caixa!");
            con.execute("UPDATE USUARIOS SET TIPO='C'  WHERE ID=1;");

            List teste = con.queryForList("SELECT * FROM "
                    + "USUARIOS");
            System.out.println(teste);
         */
 /*  JOptionPane.showMessageDialog(null, "Você cadastrou um caixa!");
            con.execute("UPDATE USUARIOS SET TIPO='T'  WHERE ID=1;");

            List teste = con.queryForList("SELECT * FROM "
            + "USUARIOS");
            System.out.println(teste);
         */
 /*  JOptionPane.showMessageDialog(null, "Você cadastrou um caixa!");
            con.execute("UPDATE USUARIOS SET TIPO='T'  WHERE ID=1;");

            List teste = con.queryForList("SELECT * FROM "
            + "USUARIOS");
            System.out.println(teste);
         */
    }

    public static void RegistrarTotem(java.awt.event.ActionEvent evt,
            Boolean checkTotem) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        if (checkTotem = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Totem!");
            con.execute("UPDATE USUARIOS SET TIPO='T'  WHERE ID=1;");

            List teste = con.queryForList("SELECT * FROM "
                    + "USUARIOS");

            teste.get(0).toString().replace("{EMAIL=", "").replace("}", "");
            System.out.println(teste);

            System.out.println("Totem cadastrado ");

        } else {
            System.out.println("totem nao cadastrado");
        }

    }

}
