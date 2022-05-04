/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import com.mycompany.omniview.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConsultaBanco {

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    AutenticarLogin al = new AutenticarLogin();
    

    //Consulta FKEstUser da tabela Usuario
    public Integer getFKEst(String email) {

        return con.queryForObject("SELECT FK_EstUser FROM USUARIO WHERE email = ? ",
                Integer.class, email);
        
    }
    

}
