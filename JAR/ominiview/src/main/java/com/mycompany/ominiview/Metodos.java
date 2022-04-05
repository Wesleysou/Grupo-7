/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ominiview;

import javax.swing.JOptionPane;

/**
 *
 * @author pedro.h.tresmondi
 */
public class Metodos {
    
    public String email;
    public String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Metodos(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public static void AutenticarLogin(String email, String senha) {
  
        if (email.equals("email") && senha.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso");
            TelaOpcao tela = new TelaOpcao();
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }
}
