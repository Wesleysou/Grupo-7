/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.Connection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class RecursosComputador {

    private String processador;
    private Integer bitMaquina;
    private String sistemaOperacional;
    private Integer arquiteturaSis;
    private Double memoriaRam;
    private Double memoriaRamTotal;
    private List processos;
    private Double discoTotal;

    public String hostName;

    AutenticarLogin autenticarLogin = new AutenticarLogin();
    Looca looca = new Looca();

    public void informacoesDoSistemaAtual() {
        //Pega o nome do processador
        processador = looca.getProcessador().getNome();
        //Pega quantos bit a maquina tem
        bitMaquina = looca.getSistema().getArquitetura();
        //Pega o sistema operacional da maquina
        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        //Arquitetura do processador
        arquiteturaSis = looca.getSistema().getArquitetura();
        //Memoria ram convertida de bytes para Gigas
        //(RAM EM USO)
        Long memoriaRamByte = looca.getMemoria().getTotal().longValue();
        memoriaRamTotal = memoriaRamByte / 1073741824.0;

        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        discoTotal = discoByte / 1073741824.0;

        //Insert na tabela maquina
    }

    public String getNomeProcessador() {

        processador = looca.getProcessador().getNome();
        return processador;
    }

    public Integer getArquitetureMaquina() {

        bitMaquina = looca.getSistema().getArquitetura();
        return bitMaquina;
    }

    public String getSistemaOperacional() {

        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        return sistemaOperacional;
    }

    public Double getMemoriaRamTotal() {

        Long memoriaRamByte = looca.getMemoria().getTotal().longValue();
        memoriaRamTotal = memoriaRamByte / 1073741824.0;
        return memoriaRamTotal;
    }

    public Double getDiscoMaquina() {

        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        discoTotal = discoByte / 1073741824.0;
        return discoTotal;
    }

    public String getHostname() {
        try {
            String Inet = InetAddress.getLocalHost().getHostName();
            hostName = Inet;

        } catch (UnknownHostException ex) {
            Logger.getLogger(RecursosComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hostName;
    }

    public String getIDMaquina() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List IdMaqBanco = con.queryForList("select ID from maquina where "
                + "hostName = ?", hostName);
        return IdMaqBanco.get(0).toString().replace("{ID=", "").replace("}", "");
    }

    public void inserirMaquinas(Integer estUsuario) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        con.update("INSERT INTO MAQUINA(hostName,"
                + "tipo,sistemaOperacional,ramTotal,arquitetura,"
                + "processador,disco,Fk_EstMaq) VALUES "
                + " (?,null,?,?,?,?,?,?)", hostName, sistemaOperacional, memoriaRamTotal,
                arquiteturaSis, processador, discoTotal, estUsuario);
        System.out.println("inserindo dados na máquina: " + this.hostName);
    }
}
