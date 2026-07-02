package com.mycompany.projmercearia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/sistema_mercearia?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "SuaSenhaAqui"; 
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySQL não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}