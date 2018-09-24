
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
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
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into seguidor(idSeguidor,nome,email,numSeguidores,numSeguidos,localizacao,url,urlImagem) values (" 
                    + seguidor.getId() + ",'" + seguidor.getNome() + "','" + seguidor.getEmail() + "'," + seguidor.getNumseguidores() + "," + seguidor.getNumseguidos()+ ",'"  + seguidor.getLocalizacao() + "','"  + seguidor.getUrl() + "','"  + seguidor.getImagem_URL() + "')";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public Seguidor read(long idSeguidor) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM seguidor WHERE idSeguidir ='" + idSeguidor + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                return new Seguidor(rs.getLong("idSeguidor"), rs.getString("nome"), rs.getString("email"),rs.getInt("numSeguidores"),rs.getInt("numSeguidos"), rs.getString("localizacao"), rs.getString("url"), rs.getString("urlImagem"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
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
