package DAO;

import DTO.FuncionarioDTO;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarFuncionarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet cadastrarFuncionario(FuncionarioDTO objcadastrarfuncionario){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "INSERT INTO funcionario (nome, idade, id_setor, id_sexo)" 
                +  "VALUES (?, ?, ?, ?)";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objcadastrarfuncionario.getNome());
           pstm.setInt   (2, objcadastrarfuncionario.getIdade());
           pstm.setInt   (3, objcadastrarfuncionario.getId_setor());
           pstm.setInt   (4, objcadastrarfuncionario.getId_sexo());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"cadastrarFuncionario erro::" + erro.getMessage());
            return null;
        }
    }
    
    public ResultSet listarSetores(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT * FROM setor");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();
           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarSetor erro:: " + erro.getMessage());
            return null;
        }
    }
    
     public ResultSet listarSexo(){
        conn = new ConexaoDAO().conectaBD();
        String sql = ("SELECT * FROM sexo");
        
        try{               
           pstm = conn.prepareStatement(sql);
           
           return pstm.executeQuery();
           
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "listarSexo erro:: " + erro.getMessage());
            return null;
        }
    }
    
}
