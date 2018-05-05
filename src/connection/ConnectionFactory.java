

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bdmercado";
    private static final String USERNAME = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
    
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASS);
            
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar manter Conexão com o Banco de Dados");
            return null;
        }
    }
    
    public static void closeConnection(Connection con){
    
        try{
            if(con!=null)
                con.close();    
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar finalizar Conexão (Connection)");
        }
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt){
    
        closeConnection(con);
        
        try{
            if(stmt!=null)
                stmt.close();    
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar finalizar Conexão (PreparedStatement)");
        }
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        try{
            if(rs!=null)
                rs.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar finalizar Conexão (ResultSet)");
        }
    }
    
}
