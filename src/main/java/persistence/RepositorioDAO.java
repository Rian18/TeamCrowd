package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
       PreparedStatement stmt = null;

        try {
            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "INSERT into repositorio(idrepositorio,url,descricao,nome,nomeCompleto,linguagem,data_criacao,observadores,num_estrelas) values (?,?,?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, repositorio.getIdRepositorio());
            stmt.setString(2, repositorio.getUrl());
            stmt.setString(3, repositorio.getDescription());
            stmt.setString(4, repositorio.getName());
            stmt.setString(5, repositorio.getFullName());
            stmt.setString(6, repositorio.getLinguagem());
            stmt.setDate(7, (Date) repositorio.getData_criacao());
            stmt.setInt(8, repositorio.getObservadores());
            stmt.setInt(9, repositorio.getNumEstrelas());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, stmt);
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

                //return new Repositorio(rs.getLong("idrepositorio"), rs.getString("description"), rs.getString("fullname"), rs.getString("namerep"), rs.getString("url"),rs.getInt("numEstrelas"), rs.getString("palavraChave"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

   /* public List<Repositorio> readAll(String palavraChave) throws ClassNotFoundException {
        List<Repositorio> lstRepositorio = new ArrayList<>();
        try {
            Connection conn = null;
            Statement st = null;

            conn = DataBaseLocator.getInstance().getConnection();
            String sql = "SELECT * FROM repositorio WHERE palavraChave = '" + palavraChave + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                lstRepositorio.add(new Repositorio(rs.getLong("idrepositorio"), rs.getString("description"), rs.getString("fullname"), rs.getString("name"), rs.getString("url"),rs.getInt("numEstrelas"), rs.getString("palavraChave")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RepositorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstRepositorio;
    }*/
    
        public List<Repositorio> readAll(String palavrachave) throws ClassNotFoundException {

        List<Repositorio> lstRepositorios = new ArrayList<Repositorio>();
      
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
                sql1 = "SELECT * FROM repositorio WHERE idRepositorio = ? ";
                stmt2 = conn.prepareStatement(sql1);
                stmt2.setInt(1, (rs.getInt("id_Repositorio")));
                ResultSet rd = stmt2.executeQuery();
                if (rd.next()) {
                    lstRepositorios.add(new Repositorio(rd.getLong("idRepositorio"), rd.getString("descricao"), rd.getString("nomeCompleto"),rd.getString("nome"),rd.getString("linguagem"),rd.getString("url"),rd.getInt("num_estrelas"), rd.getInt("observadores"),rd.getDate("data_criacao")));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RepositorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return lstRepositorios;
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
