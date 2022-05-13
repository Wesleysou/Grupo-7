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

        Double alertaDeRam = (75.0 / 100.0) * memoriaRam;
        Double alertaDeRamGrave = (5.0 / 100.0) * memoriaRam;
        Double alertaConsumoTotalRam = (95.0 / 100.0) * memoriaRam;

        do {
            try {
                if (ramEmUso >= alertaDeRam) {
                    json.put("text", String.format(" %s - :large_green_circle: 35 por cento da memoria RAM consumida!"
                            + " \n Memoria RAM atual: %.2f :large_green_circle:", hostName, ramEmUso));
                    IntegracaoSlack.sendMessage(json);
                } else if (ramEmUso >= alertaDeRamGrave) {
                    json.put("text", String.format(" %s - :large_yellow_circle: 90 por cento da memoria RAM consumida!! "
                            + "\n Memoria RAM atual: %.2f :large_yellow_circle:",  hostName, ramEmUso));
                    IntegracaoSlack.sendMessage(json);
                } else if (ramEmUso >= alertaConsumoTotalRam) {
                    json.put("text", String.format(" %s - :rotating_light: 100 por cento da memoria RAM consumuida!!! "
                            + "\n Memoria RAM atual: %.2f  :rotating_light:", hostName, ramEmUso));
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
        Double alertaDeDiscoGrave = (10.0 / 100.0) * disco;
        Double alertaConsumoTotalDisco = (95.0 / 100.0) * disco;

        do {
            try {
                if (discoEmUso <= alertaDeDisco) {
                    json.put("text", String.format(" %s - 75 por cento de disco consumido "
                            + "\n Disco atual: %.2f :large_green_circle:", hostName, discoEmUso));
                    IntegracaoSlack.sendMessage(json);
                } else if (discoEmUso <= alertaDeDiscoGrave) {
                    json.put("text", String.format(" %s - 90 por cento de disco consumido "
                            + "\n Disco atual: %.2f :large_yellow_circle: ", hostName, discoEmUso));
                    IntegracaoSlack.sendMessage(json);
                } else if (discoEmUso <= alertaConsumoTotalDisco) {
                    json.put("text", String.format(" %s - :rotating_light: Quase 100 por cento de disco consumido "
                            + "\n Disco atual: %.2f  :rotating_light:", hostName, discoEmUso));
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);
    }

    public void alertaCpu(Double cpuEmUso, String hostName) {

        Long cpuTotal = looca.getProcessador().getFrequencia();
        cpu = cpuTotal / 1073741824.0;

        Double alertaDeCpu = (60.0 / 100.0) * cpu;
        Double alertaDeCpuGrave = (10.0 / 100.0) * cpu; 
        Double alertaConsumoTotalCpu = (85.0 / 100.0) * cpu;

        do {
            try {
                if (cpuEmUso >= alertaDeCpu) {
                    json.put("text", String.format(" %s - CPU acima de 10 por cento"
                            + " \n Atual: %.2f :large_green_circle:", hostName, cpu));
                    IntegracaoSlack.sendMessage(json);
                } else if (cpuEmUso >= alertaDeCpuGrave) {
                    json.put("text", String.format(" %s - CPU acima de 75 por cento "
                            + "\n Atual: %.2f :large_yellow_circle: ", hostName, cpu));
                    IntegracaoSlack.sendMessage(json);
                } else if (cpuEmUso >= alertaConsumoTotalCpu) {
                    json.put("text", String.format("%s - :rotating_light: CPU acima 85 por cento "
                            + "\n Atual: %.2f  :rotating_light:",  hostName, cpu));
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);
    }
}
