package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioApp;
import persistence.UsuarioAppDAO;

public class LoginPostCommand implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
       try {
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            UsuarioAppDAO dao = UsuarioAppDAO.getINSTANCE();
            UsuarioApp usuario = dao.getUsuario(user, senha);
            if (usuario == null) {
                request.setAttribute("erroLogin", true);
                RequestDispatcher despachante = request.getRequestDispatcher("/login.jsp");
                despachante.forward(request, response);

            } else {
               
                request.getSession().setAttribute("usuario", usuario.getApelido());
                IndexAction comando = new IndexAction();
                comando.execute(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }}

}
