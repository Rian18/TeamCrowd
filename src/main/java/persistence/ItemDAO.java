
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Colaborador;
import model.Repositorio;
import model.Seguidor;

/**
 *
 * @author Rian Alves
 */
public class ItemDAO {
     private static final ItemDAO INSTANCE = new ItemDAO();

    public static ItemDAO getINSTANCE() {
        return INSTANCE;
    }

    public void saveRepoColab(Repositorio repositorio, Colaborador colaborador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into repocolab(repo_cod,colab_cod) values (" 
                    + repositorio.getId()+ "," + colaborador.getIdColaborador()+ ")";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }
    public void saveColabSeguidor(Seguidor seguidor, Colaborador colaborador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Statement st1 = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql1 = "SELECT id_seg FROM seguidor WHERE idSeguidor = " + seguidor.getId();
             
            ResultSet rs = st.executeQuery(sql1);
            if (rs.next()) {
                st1 = conn.createStatement();
                 String sql = "INSERT into colabseg(id_seg, seg_cod,colab_cod) values (" 
                    + seguidor.getId()+ "," + colaborador.getIdColaborador()+ ")";
            st1.execute(sql);
            }
           
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public Colaborador readRepoColab(long idRepositorio,long idColaborador) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM repocolab WHERE idColaborador ='" + idColaborador + "' AND idRepositorio = '" + idRepositorio + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                return new Colaborador(rs.getLong("idColaborador"), rs.getString("nome"), rs.getString("email"),rs.getInt("numContribuicoes"),rs.getInt("numSeguidos"),rs.getInt("numSeguidores"), rs.getString("localizacao"), rs.getString("url"), rs.getString("urlImagem"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }
    public Seguidor readColabSeg(long idSeguidor,long idColaborador) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM colabseg WHERE idColaborador ='" + idColaborador + "' AND idSeguidor = '" + idSeguidor + "'";
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
