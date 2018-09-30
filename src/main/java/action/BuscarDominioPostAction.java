
package action;

import br.ufjf.teamcrowd.MineradorGit;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Rian Alves
 */
public class BuscarDominioPostAction implements Action  {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            String keyword = request.getParameter("keyword");
            
            MineradorGit mineracao = new MineradorGit();
            mineracao.Busca(keyword);           
            //RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/Repositorio.jsp");
           request.setAttribute("palavraChave", keyword);
            //dispacher.forward(request, response);
            response.sendRedirect("visualizaDados.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(BuscarDominioPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
