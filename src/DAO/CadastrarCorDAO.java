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
public class CadastrarCorDAO {
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet cadastrarCor(OutroDTO objcadastrarcor){
    conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "INSERT INTO cor (descricao)" 
                +  "VALUES (?)";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objcadastrarcor.getDescricao());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"cadastrarCor erro::" + erro.getMessage());
            return null;
        }
    }
}
