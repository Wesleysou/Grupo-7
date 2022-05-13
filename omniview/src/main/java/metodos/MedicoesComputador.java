/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.omniview.Connection;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

public class MedicoesComputador {

    private Double memoriaRam;
    private Integer processos;
    private Double cpuEmUso;
    private Double discoEmUso;


    Looca looca = new Looca();
    AlertasSlack slack = new AlertasSlack();
    RecursosComputador rec = new RecursosComputador();
    metodos.ConsultaBanco cntsBanco = new ConsultaBanco();

    public void informacoesDoSistema() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        //Pega a quantidade de processos sendo executados no momento
        processos = looca.getGrupoDeProcessos().getTotalProcessos();

        //Total de Disco
        Long discoByte = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel();
        discoEmUso = discoByte / 1073741824.0;
        slack.alertaDisco(discoEmUso, rec.getHostname());

        //CPU
        cpuEmUso = looca.getProcessador().getUso();
        slack.alertaCpu(cpuEmUso, rec.getHostname());

        Long memoriaRamByte = looca.getMemoria().getEmUso();
        memoriaRam = memoriaRamByte / 1073741824.0;
        slack.alertaRam(memoriaRam,rec.getHostname());

        con.update("Insert into medicoes"
                + " (ram,usoDoDisco,cpuM,processos,diaHorario,Fk_MaqRe) "
                + "values (?, ?, ?, ?,GETDATE(),?)"
                , memoriaRam, discoEmUso,
                cpuEmUso, processos,cntsBanco.getIDMaquina());
        
    }

    public void informacaomemoria() {
        int delay = 10000;   // delay de 10 seg.
        int interval = 1000;  // intervalo de 10 seg.
        // Timer timer = new Timer();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                inserirDados();

            }
        }, delay, interval);
    }

    public void inserirDados() {

        MedicoesComputador recMemoria = new MedicoesComputador();

    
        recMemoria.informacoesDoSistema();
        System.out.println("Gravando dados na tabela Medições");

    }

    public Double getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Double memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public Integer getProcessos() {
        return processos;
    }

    public void setProcessos(Integer processos) {
        this.processos = processos;
    }

    public Double getCpuEmUso() {
        return cpuEmUso;
    }

    public void setCpuEmUso(Double cpuEmUso) {
        this.cpuEmUso = cpuEmUso;
    }

    public Double getDiscoEmUso() {
        return discoEmUso;
    }

    public void setDiscoEmUso(Double discoEmUso) {
        this.discoEmUso = discoEmUso;
    }

    public Looca getLooca() {
        return looca;
    }

    public void setLooca(Looca looca) {
        this.looca = looca;
    }

    public AlertasSlack getSlack() {
        return slack;
    }

    public void setSlack(AlertasSlack slack) {
        this.slack = slack;
    }

    public RecursosComputador getRec() {
        return rec;
    }

    public void setRec(RecursosComputador rec) {
        this.rec = rec;
    }

    public ConsultaBanco getCntsBanco() {
        return cntsBanco;
    }

    public void setCntsBanco(ConsultaBanco cntsBanco) {
        this.cntsBanco = cntsBanco;
    }
  
}
