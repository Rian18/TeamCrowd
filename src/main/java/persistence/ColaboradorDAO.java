
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Colaborador;
import model.Repositorio;


/**
 *
 * @author Rian Alves
 */
public class ColaboradorDAO {
     private static final ColaboradorDAO INSTANCE = new ColaboradorDAO();

    public static ColaboradorDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into colaborador(idcolaborador,nome,email,numContribuicoes,numSeguidores,numSeguidos,localizacao,urlImagem,url) values (" 
                    + colaborador.getIdColaborador() + ",'" + colaborador.getNome() + "','" + colaborador.getEmail() + "'," + colaborador.getContribuicao() + "," + colaborador.getNumseguidos() + "," + colaborador.getNumseguidores()+ ",'"  + colaborador.getLocalizacao() + "','"  + colaborador.getUrl() + "','"  + colaborador.getImagem_URL() + "')";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public Colaborador read(long idColaborador) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM colaborador WHERE idColaborador ='" + idColaborador + "'";
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

   public List<Colaborador> readAll(Long idRepositorio) throws ClassNotFoundException {
        List<Colaborador> lstColaboradores = new ArrayList<>();
        try {
            Connection conn = null;
            Statement st = null;

            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM repocolab WHERE idRepositorio = '" + idRepositorio + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSet rd = null;
            if (rs.next()) {
                rd = st.executeQuery("SELECT * FROM colaborador WHERE idColaborador = '" + rs.getLong("idColaborador") + "'");
                lstColaboradores.add(new Colaborador(rd.getLong("idColaborador"), rd.getString("nome"), rd.getString("email"),rd.getInt("numContribuicoes"),rd.getInt("numSeguidos"),rd.getInt("numSeguidores"), rd.getString("localizacao"), rd.getString("url"), rd.getString("urlImagem")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RepositorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstColaboradores;
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
