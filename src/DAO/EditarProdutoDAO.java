package DAO;

import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class EditarProdutoDAO {
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet atualizarProduto(ProdutoDTO objatualizarproduto){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = ("UPDATE produto SET descricao = ?, id_marca = ?, id_cor = ? "
                   + "WHERE id = ?");
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objatualizarproduto.getDescricao());
           pstm.setInt   (2, objatualizarproduto.getId_marca());
           pstm.setInt   (3, objatualizarproduto.getId_cor());
           pstm.setInt   (4, objatualizarproduto.getId());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"atualizarFuncionario erro::" + erro.getMessage());
            return null;
        }
    }

    public ResultSet listarProdutos(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT id, descricao FROM produto");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();          
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarProdutos erro:: " + erro.getMessage());
            return null;
        }
    }    
}
