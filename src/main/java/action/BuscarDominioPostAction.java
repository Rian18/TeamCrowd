package action;

import br.ufjf.teamcrowd.MineradorGit;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Colaborador;
import persistence.ColaboradorDAO;

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
            List<Colaborador> lstColaboradores = new ArrayList<>();
            lstColaboradores = ColaboradorDAO.getINSTANCE().readAll(keyword);
            request.setAttribute("colaboradores", lstColaboradores);
            RequestDispatcher despachante = request.getRequestDispatcher("/visualizaDados.jsp");
            despachante.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarDominioPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
