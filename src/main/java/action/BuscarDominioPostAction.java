package action;

import br.ufjf.teamcrowd.MineradorGit;
import com.google.gson.Gson;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.Repositorio;
import persistence.ColaboradorDAO;
import persistence.RepositorioDAO;

/**
 *
 * @author Rian Alves
 */
public class BuscarDominioPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            String keyword = request.getParameter("keyword");

            MineradorGit mineracao = new MineradorGit();
            mineracao.Busca(keyword);

            List<Repositorio> lstRepositorios = new ArrayList<>();
            lstRepositorios = RepositorioDAO.getINSTANCE().readAll(keyword);
            //Collections.sort(lstRepositorios);
            request.setAttribute("repositorios", lstRepositorios);

            List<Colaborador> lstColaboradores = new ArrayList<>();
            lstColaboradores = ColaboradorDAO.getINSTANCE().readAll(keyword);
            request.setAttribute("colaboradores", lstColaboradores);

            Collections.sort(lstColaboradores);
            List<Colaborador> lstColaboradoresSugeridos = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                lstColaboradoresSugeridos.add(lstColaboradores.get(i));
            }
            request.setAttribute("sugeridos", lstColaboradoresSugeridos);

            Gson gson = new Gson();
            String colaboradoresJson = gson.toJson(lstColaboradoresSugeridos);
            request.setAttribute("colaboradoresJson", colaboradoresJson);
            
            RequestDispatcher despachante = request.getRequestDispatcher("/visualizaDados.jsp");
            despachante.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(BuscarDominioPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
