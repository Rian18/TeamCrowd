
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Seguidor;

/**
 *
 * @author Rian Alves
 */
public class SeguidorDAO {
     private static final SeguidorDAO INSTANCE = new SeguidorDAO();

    public static SeguidorDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Seguidor seguidor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "INSERT into seguidor(idUsuario,idSeguidor,nome,email,login,url,localizacao,avatar_url) values (?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, seguidor.getIdSeguido());
            stmt.setLong(2, seguidor.getId());
            stmt.setString(3, seguidor.getNome());
            stmt.setString(4, seguidor.getEmail());
            stmt.setString(5, seguidor.getLogin());
            stmt.setString(6, seguidor.getUrl());
            stmt.setString(7, seguidor.getLocalizacao());
            stmt.setString(8, seguidor.getImagem_URL());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, stmt);
        }

    }

     

    private void closeResources(Connection conn, PreparedStatement st) {
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
