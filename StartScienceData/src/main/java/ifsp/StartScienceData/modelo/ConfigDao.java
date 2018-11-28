package ifsp.StartScienceData.modelo;

import java.sql.*;

public class ConfigDao {
    private Connection conexao; 

    public String conectaBD() { 
        String strCon = "jdbc:mysql://localhost/mydb?user=root&password=&useTimezone=true&serverTimezone=UTC&useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            conexao = DriverManager.getConnection(strCon); 
        } catch (Exception e) {
        	
            return "Tipo de Excessão: " + e.getClass().getSimpleName() + "\n * Mensagem: " + e.getMessage(); 
        }
        return null; 
    }

    public void desconectaBD() { 
        try {
            conexao.close();
        } catch (Exception e) {
        	
        }
    }

    public Connection getConexaoBD() { 
        return conexao;
    }
}