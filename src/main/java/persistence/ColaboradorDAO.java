package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        PreparedStatement stmt = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "INSERT into usuario(idUsuario,nome,email,contribuicao,num_seguidores,num_seguidos,localizacao,avatar_url,url,criado_em) values (?,?,?,?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, colaborador.getIdColaborador());
            stmt.setString(2, colaborador.getNome());
            stmt.setString(3, colaborador.getEmail());
            stmt.setInt(4, colaborador.getContribuicao());
            stmt.setInt(5, colaborador.getNumseguidores());
            stmt.setInt(6, colaborador.getNumseguidos());
            stmt.setString(7, colaborador.getLocal());
            stmt.setString(8, colaborador.getImagem_URL());
            stmt.setString(9, colaborador.getUrl());
            stmt.setDate(10, (Date) colaborador.getCriado_em());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, stmt);
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

                return new Colaborador(rs.getLong("idColaborador"), rs.getString("nome"), rs.getString("email"), rs.getInt("numContribuicoes"), rs.getInt("numSeguidos"), rs.getInt("numSeguidores"), rs.getString("localizacao"), rs.getString("url"), rs.getString("urlImagem"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    public List<Colaborador> readAll(String palavrachave) throws ClassNotFoundException {

        List<Colaborador> lstColaboradores = new ArrayList<Colaborador>();
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
     
        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM reposusuario WHERE palavrachave = ? " ;
             String sql1 ="";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, palavrachave);
            ResultSet rs = stmt1.executeQuery();
            
           
            while (rs.next()) {  
                sql1 = "SELECT * FROM usuario WHERE idUsuario = ? ";
                stmt2 = conn.prepareStatement(sql1);
                stmt2.setInt(1, (rs.getInt("id_Usuario")));
                ResultSet rd = stmt2.executeQuery();
                if (rd.next()) {
                    lstColaboradores.add(new Colaborador(rd.getLong("idUsuario"), rd.getString("nome"), rd.getString("email"),rd.getString("login"),rd.getInt("contribuicao"), rd.getInt("num_Seguidores"), rd.getInt("num_Seguidos"), rd.getString("localizacao"), rd.getString("url"),rd.getString("avatar_url"),rd.getDate("criado_em")));
                }
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
