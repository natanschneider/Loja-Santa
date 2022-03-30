package DAO;

import DTO.ProdutoDTO;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Natan
 */
public class CadastrarProdutoDAO {
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet cadastrarProduto(ProdutoDTO objcadastrarproduto){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "INSERT INTO produto (descricao, id_marca, id_cor)" 
                +  "VALUES (?, ?, ?)";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objcadastrarproduto.getDescricao());
           pstm.setInt   (2, objcadastrarproduto.getId_marca());
           pstm.setInt   (3, objcadastrarproduto.getId_cor());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"cadastrarProduto erro::" + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet listarCores(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT * FROM cor");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();
           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarCor erro:: " + erro.getMessage());
            return null;
        }
    }
    
     public ResultSet listarMarca(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT * FROM marca");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();
           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarMarca erro:: " + erro.getMessage());
            return null;
        }
    }
    
}
