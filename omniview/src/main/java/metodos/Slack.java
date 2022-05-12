package metodos;

import com.github.britooo.looca.api.core.Looca;
import java.util.Objects;
import org.json.JSONObject;

public class Slack {
    
    private Double memoriaRam;
    private Double disco;

    JSONObject json = new JSONObject();
    AutenticarLogin loginAutenticado = new AutenticarLogin();
    Looca looca = new Looca();
    

    public void alertaRam(Double ramEmUso, String hostName) {
        
        Long ramTotal = looca.getMemoria().getTotal();
        memoriaRam = ramTotal / 1073741824.0;
        
        Double alertaDeRam = (75.0 / 100.0) * memoriaRam;
        Double alertaDeRamGrave = (90.0 / 100.0) * memoriaRam;
        Double alertaConsumoTotalRam = (100.0 / 100.0) * memoriaRam;
        
        do {
            try {
                if (ramEmUso >= alertaDeRam) {
                    json.put("text",String.format(" %s - 75 da memoria consumida", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                if (ramEmUso >= alertaDeRamGrave){
                    json.put("text",String.format(" %s - 90 da memoria consumida", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                if(Objects.equals(ramEmUso, alertaConsumoTotalRam)){
                    json.put("text",String.format(" %s - 100 da memoria consumuida ", hostName));
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
        
        Double alertaDeDisco = (75.0 / 100.0) * disco;
        Double alertaDeDiscoGrave = (90.0 / 100.0) * disco;
        Double alertaConsumoTotalDisco = (100.0 / 100.0) * disco;
        
        do {            
            try {
                if (discoEmUso >= alertaDeDisco) {
                    json.put("text",String.format(" %s - 75 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                if (discoEmUso >= alertaDeDiscoGrave){
                    json.put("text",String.format(" %s - 90 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
                if(Objects.equals(discoEmUso, alertaConsumoTotalDisco)){
                    json.put("text",String.format(" %s - 100 de disco consumuido", hostName));
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);
    }
    
}
