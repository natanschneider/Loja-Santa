package DAO;

import DTO.OutroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Natan
 */
public class CadastrarSetorDAO {
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet cadastrarSetor(OutroDTO objcadastrarsetor){
    conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "INSERT INTO setor (descricao)" 
                +  "VALUES (?)";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objcadastrarsetor.getDescricao());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"cadastrarSetor erro::" + erro.getMessage());
            return null;
        }
    }
}
