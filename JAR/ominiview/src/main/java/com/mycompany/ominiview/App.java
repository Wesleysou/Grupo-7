package com.mycompany.ominiview;


import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        
        con.execute("DROP TABLE IF EXISTS USUARIOS");
    }

}
