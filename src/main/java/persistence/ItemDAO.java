package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private int cont = 0;

    public static ItemDAO getINSTANCE() {
        return INSTANCE;
    }

    public void saveReposusuario(Repositorio repositorio, Colaborador colaborador, String palavraChave) throws SQLException, ClassNotFoundException {
        Connection conn = null;
       PreparedStatement stmt = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            
            String sql = "INSERT into reposusuario(id_Repositorio,id_Usuario,palavrachave) values (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, repositorio.getIdRepositorio());
            stmt.setLong(2, colaborador.getIdColaborador());
            stmt.setString(3, palavraChave );
            stmt.execute();
                 
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, stmt);
        }

    }

  
    
   /* public int id_seguidor(Seguidor seguidor) throws SQLException
    {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            String sql = "SELECT * FROM  into colabseg(id_seg,seg_cod,colab_cod) values (" + 1 + ","
                    + seguidor.getIdSeguidor() + "," + colaborador.getIdColaborador() + ")";
            st.execute(sql);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    
    }*/

    public Colaborador readRepoColab(long idRepositorio, long idColaborador) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM repocolab WHERE idColaborador ='" + idColaborador + "' AND idRepositorio = '" + idRepositorio + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                return new Colaborador(rs.getLong("idColaborador"), rs.getString("nome"), rs.getString("email"), rs.getInt("numContribuicoes"), rs.getInt("numSeguidos"), rs.getInt("numSeguidores"), rs.getString("localizacao"), rs.getString("url"), rs.getString("urlImagem"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            //closeResources(conn, st);
        }
        return null;
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
