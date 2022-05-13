package metodos;

import com.github.britooo.looca.api.core.Looca;
import java.util.Objects;
import org.json.JSONObject;

public class AlertasSlack {
    
    private Double memoriaRam;
    private Double disco;
    private Double cpu;

    JSONObject json = new JSONObject();
    AutenticarLogin loginAutenticado = new AutenticarLogin();
    Looca looca = new Looca();
    

    public void alertaRam(Double ramEmUso, String hostName) {
        
        Long ramTotal = looca.getMemoria().getTotal();
        memoriaRam = ramTotal / 1073741824.0;
        
        Double alertaDeRam = (35.0 / 100.0) * memoriaRam;
        Double alertaDeRamGrave = (75.0 / 100.0) * memoriaRam;
        Double alertaConsumoTotalRam = (95.0 / 100.0) * memoriaRam;
        
        do {
            try {
                if (ramEmUso >= alertaDeRam) {
                    json.put("text",String.format(" %s - 35 por cento da memoria consumida, memoria atual: %.2f", hostName,ramEmUso));
                    IntegracaoSlack.sendMessage(json);
                }
                else if (ramEmUso >= alertaDeRamGrave){
                    json.put("text",String.format(" %s - 90% da memoria consumida", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                else if(ramEmUso >= alertaConsumoTotalRam){
                    json.put("text",String.format(" %s - 100% da memoria consumuida ", hostName));
                    IntegracaoSlack.sendMessage(json);
                } 
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);

    }

    public void alertaDisco(Double discoEmUso, String hostName) {
        
        Long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal();
        disco = discoTotal / 1073741824.0;
        
        Double alertaDeDisco = (10.0 / 100.0) * disco;
        Double alertaDeDiscoGrave = (75.0 / 100.0) * disco;
        Double alertaConsumoTotalDisco = (95.0 / 100.0) * disco;
        
        do {            
            try {
                if (discoEmUso >= alertaDeDisco) {
                    json.put("text",String.format(" %s - 75 de disco consumuido - disco atual %.2f", hostName,discoEmUso));
                    IntegracaoSlack.sendMessage(json);
                }
                else if (discoEmUso >= alertaDeDiscoGrave){
                    json.put("text",String.format(" %s - 90 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                else if(discoEmUso >= alertaConsumoTotalDisco){
                    json.put("text",String.format(" %s - 100 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);
    }
    
    public void alertaCpu(Double cpuEmUso, String hostName){
        
        Long cpuTotal = looca.getProcessador().getFrequencia();
        cpu = cpuTotal / 1073741824.0;
        
        Double alertaDeCpu = (35.0 / 100.0) * cpu;
        Double alertaDeCpuGrave = (75.0 / 100.0) * cpu;
        Double alertaConsumoTotalCpu = (95.0 / 100.0) * cpu;
        
        do {            
            try {
                if (cpuEmUso >= alertaDeCpu) {
                    json.put("text",String.format(" %s - 75 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                else if (cpuEmUso >= alertaDeCpuGrave){
                    json.put("text",String.format(" %s - 90 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                else if(cpuEmUso >= alertaConsumoTotalCpu){
                    json.put("text",String.format(" %s - 100 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);
    }
}
