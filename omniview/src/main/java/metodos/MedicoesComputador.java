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
    private Double cpuTotal;
    private Double discoTotal;
    Looca looca = new Looca();

    public void informacoesDoSistema() {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        //Pega a quantidade de processos sendo executados no momento
        processos = looca.getGrupoDeProcessos().getTotalProcessos();

        //Total de Disco
        Long discoByte = looca.getGrupoDeDiscos().getTamanhoTotal();
        discoTotal = discoByte / 1073741824.0;

        //CPU
        Long cpuBytes = looca.getProcessador().getFrequencia();
        cpuTotal = cpuBytes / 1073741824.0;

        Long memoriaRamByte = looca.getMemoria().getEmUso();
        memoriaRam = memoriaRamByte / 1073741824.0;

        con.update("Insert into medicoes"
                + " (ram,disco,cpuM,processos,diaHorario,Fk_MaqRe) "
                + "values (?, ?, ?, ?,GETDATE(),500)", memoriaRam,discoTotal,
        cpuTotal,processos);
        
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
        System.out.println("Gravando dados na tabela Medicoes");

        

    }
}
