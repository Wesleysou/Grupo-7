package com.mycompany.ominiview;

import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        //StringBuilder createStatement = new StringBuilder();

        
        List usuariosBanco = con.queryForList("SELECT * FROM USUARIOS");
        

        System.out.println(usuariosBanco);

    }

}
