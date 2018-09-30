
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UsuarioApp;

/**
 *
 * @author Rian Alves
 */
public class UsuarioAppDAO {
    
    private static final UsuarioAppDAO INSTANCE = new UsuarioAppDAO();

    public static UsuarioAppDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(UsuarioApp usuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "INSERT into usuario(nome,apelido,urlGit,email,foto_url,senha) values (?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getApelido());
            stmt.setString(3, usuario.getUrlGit());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getFoto_url());
            stmt.setString(6, usuario.getSenha());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, stmt);
        }

        
    }

    public UsuarioApp read(String apelido) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM colaborador WHERE apelido ='" + apelido + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                return new UsuarioApp(rs.getString("nome"),rs.getString("apelido"), rs.getString("urlGit"),
                         rs.getString("email"), rs.getString("foto_url"), rs.getString("senha"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }
    
     public UsuarioApp getUsuario(String apelido, String senha) throws SQLException {
         Connection conn = null;
         UsuarioApp usuario = null;
        try {
         
            conn = DataBaseLocator.getInstance().getConnection();
            try (PreparedStatement consulta = conn.prepareStatement("Select * from usuarioapp where apelido = ? AND senha = ?")) {
                consulta.setString(1, apelido);
                consulta.setString(2, senha);
                consulta.setMaxRows(1);
                consulta.execute();
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) {
                    usuario = new UsuarioApp(resultado.getString("nome"),resultado.getString("apelido"), resultado.getString("urlGit"),
                            resultado.getString("email"), resultado.getString("foto_url"), resultado.getString("senha"));
                    
                }
            }
           
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioAppDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return usuario;
    }
    
    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
    }
}
