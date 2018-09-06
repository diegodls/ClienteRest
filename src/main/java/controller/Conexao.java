package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost/db_apsweb", "postgres", "diego");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    public void desconectar(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Connection con = new Conexao().conectar();
        if (con != null){
            System.out.println("Conexão realizada com sucesso!");
        }
    }
    
}
