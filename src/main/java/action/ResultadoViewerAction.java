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
        List<Colaborador> lstColaboradoresRETORNO = new ArrayList<>();
        String keyword = (String) request.getAttribute("palavraChave");

        lstRepositorio = RepositorioDAO.getINSTANCE().readAll(keyword);
        for (Repositorio repositorio : lstRepositorio) {
            lstColaboradores = ColaboradorDAO.getINSTANCE().readAll(repositorio.getId());
            for (Colaborador colaborador : lstColaboradores) {
                if (colaborador.getContribuicao() > 1) {
                    lstColaboradoresRETORNO.add(colaborador);
                }

            }
            lstColaboradores.clear();
        }

        request.setAttribute("colaboradores", lstColaboradoresRETORNO);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/Informacoes.jsp");
        despachante.forward(request, response);

    }

}
