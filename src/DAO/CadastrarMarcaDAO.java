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
public class CadastrarMarcaDAO {
    Connection conn;
    PreparedStatement pstm;
    public ResultSet rs;
    
    public ResultSet cadastrarMarca(OutroDTO objcadastrarmarca){
    conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "INSERT INTO marca (descricao)" 
                +  "VALUES (?)";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objcadastrarmarca.getDescricao());
           
           pstm.executeUpdate();
    
           return null;       
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"cadastrarMarca erro::" + erro.getMessage());
            return null;
        }
    }
}
