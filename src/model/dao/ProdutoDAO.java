

package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Produto;



public class ProdutoDAO {

    public void create(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO produto(codigo, descricao, preco) VALUE (?, ?, ?)");
            stmt.setInt(1, p.getCodigo());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir os Dados");    
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public List<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> vetProd = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM PRODUTO");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto prod = new Produto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                
                vetProd.add(prod);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao tentar ler os dados");
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return vetProd;
    }
    
}
