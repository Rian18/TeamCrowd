package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Repositorio;

public class RepositorioDAO {

    private static final RepositorioDAO INSTANCE = new RepositorioDAO();

    public static RepositorioDAO getINSTANCE() {
        return INSTANCE;
    }

    public void save(Repositorio repositorio) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT into repositorio(idrepositorio,description,fullname,namerep,url,palavraChave) values (" + repositorio.getId() + ",'" + repositorio.getDescription() + "','" + repositorio.getFullName() + "','" + repositorio.getName() + "','" + repositorio.getUrl() + "','" + repositorio.getPalavraChave() + "')";
            st.execute(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public Repositorio read(long idRepositorio) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM repositorio WHERE idrepositorio ='" + idRepositorio + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                return new Repositorio(rs.getLong("idrepositorio"), rs.getString("description"), rs.getString("fullname"), rs.getString("namerep"), rs.getString("url"), rs.getString("palavraChave"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    public List<Repositorio> readAll(String palavraChave) throws ClassNotFoundException {
        List<Repositorio> lstRepositorio = new ArrayList<>();
        try {
            Connection conn = null;
            Statement st = null;

            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM repositorio WHERE palavraChave = '" + palavraChave + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                lstRepositorio.add(new Repositorio(rs.getLong("idrepositorio"), rs.getString("description"), rs.getString("fullname"), rs.getString("name"), rs.getString("url"), rs.getString("palavraChave")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RepositorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstRepositorio;
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
