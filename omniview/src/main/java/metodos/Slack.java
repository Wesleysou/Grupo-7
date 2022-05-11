package metodos;

import org.json.JSONObject;

public class Slack {

    JSONObject json = new JSONObject();
    AutenticarLogin loginAutenticado = new AutenticarLogin();

    public void alertaRam(Double memoriaRam, String hostName) {
        do {
            try {
                if (memoriaRam > 2.0) {
                    json.put("text", "Ram " + hostName + " acima do esperado");
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);

    }

    public void alertaDisco(Double discoUso, String hostName) {
        do {            
            try {
                if (discoUso > 330.0) {
                    json.put("text", "Disco " + hostName + " acima do esperado ");
                    IntegracaoSlack.sendMessage(json);
                }
            } catch (Exception e) {
                System.out.println("erro");
            }
        } while (loginAutenticado.isUserAutenticado() == true);
    }
}
