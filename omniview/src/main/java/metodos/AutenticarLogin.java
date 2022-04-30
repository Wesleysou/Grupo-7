package metodos;

import com.mycompany.omniview.Connection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswing.TelaLogin;
import javaswing.TelaOpcao;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import user.User;

public class AutenticarLogin {

    private String email;
    private String senha;
    private String id;

    public AutenticarLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

    public AutenticarLogin() {
    }

    public String getEmail() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List emailUsuariosBanco = con.queryForList("SELECT EMAIL FROM "
                + "USUARIO WHERE EMAIL = ?", email);

        return emailUsuariosBanco.get(0).toString().replace("{EMAIL=", "").replace("}", "");

    }

    public String getSenha() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List senhaUsuariosBanco = con.queryForList("SELECT SENHA FROM "
                + "USUARIO WHERE SENHA = ?", senha);
        return senhaUsuariosBanco.get(0).toString().replace("{SENHA=", "").replace("}", "");
    }

    public String getId() {
        return this.id;
    }

    public static void AbrirLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }

        });

    }

    public void AutenticarLogin(String email, String senha,
            String emailUsuarioBanco, String senhaUsuarioBanco) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List<User> usuario = con.query("SELECT EMAIL, SENHA FROM USUARIO "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);
        List<User> usuarioId = con.query("SELECT ID FROM USUARIO "
                + "WHERE EMAIL =? and SENHA =?",
                new BeanPropertyRowMapper<>(User.class), email, senha);
        if (usuario.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Acesso negado \n Usuário ou "
                    + "senha incorretos");
        } else {
            this.email = emailUsuarioBanco;
            System.out.println("Email do que retornou do banco:" + emailUsuarioBanco);

            JOptionPane.showMessageDialog(null, "Autenticado");
            TelaOpcao tela = new TelaOpcao(usuarioId);
            tela.setVisible(true);
            TelaLogin teste = new TelaLogin();
            teste.setVisible(false);
            metodos.RecursosComputador regMaq = new RecursosComputador();
            regMaq.informacoesDoSistemaAtual();
            regMaq.inserirMaquinas();
            gravarEmail();

        }

    }

    public void gravarEmail() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        try {
            con.update("UPDATE maquina SET proprietarioMaq = ? WHERE ID = 500",
                    this.email);
            String Inet = InetAddress.getLocalHost().getHostName();
            con.update("UPDATE MAQUINA SET HOSTNAME  = ? WHERE proprietarioMaq  = ?",
                    Inet, this.email);

        } catch (UnknownHostException ex) {
            Logger.getLogger(RecursosComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RegistrarCaixa(java.awt.event.ActionEvent evt,
            Boolean checkCaixa) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        if (checkCaixa = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Caixa!");
            con.update("UPDATE MAQUINA SET TIPO='C' WHERE ID = 500");

            List teste = con.queryForList("SELECT * FROM "
                    + "MAQUINA  WHERE ID =500");

            System.out.println(teste);
            System.out.println("Caixa cadastrado");

        } else {
            System.out.println("caixa nao cadastrado");
        }
    }

    public void RegistrarTotem(java.awt.event.ActionEvent evt,
            Boolean checkTotem) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        System.out.println("email do totem : " + email);
        if (checkTotem = true) {
            JOptionPane.showMessageDialog(null, "Você cadastrou um Totem!");
            con.update("UPDATE MAQUINA SET TIPO='T'WHERE ID = 500");

            List teste = con.queryForList("SELECT * FROM "
                    + "MAQUINA WHERE ID = 500");
            teste.get(0).toString().replace("{EMAIL=", "").replace("}", "");
            System.out.println(teste);

            System.out.println("Totem cadastrado ");

        } else {
            System.out.println("totem nao cadastrado");
        }

    }

//    public void inserirMaquinas() {
//        Connection config = new Connection();
//        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
//
//        RecursosComputador hardwareInfo = new RecursosComputador();
//        String so = hardwareInfo.getSistemaOperacional();
//        Double RamTotal = hardwareInfo.getMemoriaRamTotal();
//        Integer arquitetura = hardwareInfo.getArquiteturaSis();
//        String processador = hardwareInfo.getProcessador();
//        Integer QtdDiscos = hardwareInfo.getQuantidadeDiscos();
//        
//        con.update("INSERT INTO MAQUINA(hostName,proprietarioMaq,"
//                + "tipo,sistemaOperacional,ramTotal,arquitetura,"
//                + "processador,disco,Fk_EstMaq) VALUES "
//                + " (null,?,null,?,?,?,?,?,?)", this.email,so,RamTotal,arquitetura
//                , processador,QtdDiscos, 1);
//                
//        System.out.println("Gravando informacoes na tabela maquina");
//        System.out.println(hardwareInfo.toString());
//    }
}
