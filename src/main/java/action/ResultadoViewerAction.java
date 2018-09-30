package action;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class ResultadoViewerAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Repositorio> lstRepositorio = new ArrayList<>();
        List<Colaborador> lstColaboradores = new ArrayList<>();
       // String keyword = (String) request.getAttribute("palavraChave");

        //lstRepositorio = RepositorioDAO.getINSTANCE().readAll("Ecossistemas de Software");
        /*for (Repositorio repositorio : lstRepositorio) {
            lstColaboradores = ColaboradorDAO.getINSTANCE().readAll();
            for (Colaborador colaborador : lstColaboradores) {
                if (colaborador.getContribuicao() > 1) {
                    lstColaboradoresRETORNO.add(colaborador);
                }

            }
            lstColaboradores.clear();
        }
        
        lstColaboradores = ColaboradorDAO.getINSTANCE().readAll(keyword);
        request.setAttribute("colaboradores", lstColaboradores);
        RequestDispatcher despachante = request.getRequestDispatcher("/visualizaDados.jsp");
        despachante.forward(request, response);*/

    }

}
