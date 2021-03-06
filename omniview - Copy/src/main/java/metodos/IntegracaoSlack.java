package metodos;

import com.mycompany.omniview.Connection;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class IntegracaoSlack {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    metodos.RecursosComputador reqMaq = new RecursosComputador();

    public Integer consultaEmpresa() {
        List IdMaqBanco = con.queryForList("select Fk_EstMaq from Maquina where hostName = ? ORDER BY ID DESC",
                reqMaq.getHostname());
        String fkVar = String.valueOf(IdMaqBanco.get(0)).replace("{Fk_EstMaq=", "").replace("}", "");
        System.out.println(fkVar);
        Integer fkVarInt = Integer.parseInt(fkVar);
        return fkVarInt;
    }

    public void enviaAlerta(Integer fkVarInt) {
        if (fkVarInt == 1) {
            System.out.println("caiu no 1");

        } else if (fkVarInt == 2) {
            System.out.println("caiu no 2");
        }

    }

    public static void getEnviaAlertasCmMikeys(String tipoAlerta, String corAlerta, String hostName, String tipoMedicao, Double ramEmUso) throws Exception {
        String token = "xoxb-3467541436532-3524285250806-cxcwkjJzm7o7qknpNc5AQ5Nr";
        String msgAlerta = String.format("%s %s\n"
                + "Máquina: %s\n"
                + "%s Disponivel: %.2f GB",
                tipoAlerta, corAlerta, hostName, tipoMedicao, ramEmUso);

        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods(token);

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#cm-mikeys") // Use a channel ID `C1234567` is preferrable
                .text(msgAlerta)
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        System.out.println(response);
        System.out.println(response.getError());
    }

    public static void getEnviaAlertasBurgerqueen(String tipoAlerta, String corAlerta, String hostName, String tipoMedicao, Double ramEmUso) throws Exception {
        String token = "xoxb-3467541436532-3524285250806-cxcwkjJzm7o7qknpNc5AQ5Nr";
        String msgAlerta = String.format("%s %s\n"
                + "Máquina: %s\n"
                + "%s Disponivel: %.2f GB",
                tipoAlerta, corAlerta, hostName, tipoMedicao, ramEmUso);

        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods(token);

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#burgerqueen") // Use a channel ID `C1234567` is preferrable
                .text(msgAlerta)
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);

        System.out.println(response);
        System.out.println(response.getError());
    }
}
