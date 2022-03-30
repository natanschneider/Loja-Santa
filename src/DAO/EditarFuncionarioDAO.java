package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class EditarFuncionarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public ResultSet atualizarFuncionario(FuncionarioDTO objatualizarfuncionario){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = ("UPDATE funcionario SET nome = ?, idade = ?, id_setor = ?, id_sexo = ? "
                   + "WHERE id = ?");
           
           pstm = conn.prepareStatement(sql);

           pstm.setString(1, objatualizarfuncionario.getNome());
           pstm.setInt   (2, objatualizarfuncionario.getIdade());
           pstm.setInt   (3, objatualizarfuncionario.getId_setor());
           pstm.setInt   (4, objatualizarfuncionario.getId_sexo());
           pstm.setInt   (5, objatualizarfuncionario.getId());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"atualizarFuncionario erro::" + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet listarNomes(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT id, nome FROM funcionario");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarNomes erro:: " + erro.getMessage());
            return null;
        }
    }
}