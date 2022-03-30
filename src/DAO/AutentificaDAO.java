package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class AutentificaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public ResultSet autentificaUsuario(UsuarioDTO objusuariodto){
        conn = new ConexaoDAO().conectaBD();
        try{
           String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
           
           pstm = conn.prepareStatement(sql);
           
           pstm.setString(1, objusuariodto.getEmail());
           pstm.setString(2, objusuariodto.getSenha());
           
           rs = pstm.executeQuery();
    
           return rs;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"autentificaUsuario erro::" + erro.getMessage());
            return null;
        }
    }
}
