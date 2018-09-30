package action;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.Repositorio;

/**
 *
 * @author Rian Alves
 */
public class FormarGrupoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
    
        List<Repositorio> lstRepositorio = new ArrayList<>();
        List<Colaborador> lstColaboradores = new ArrayList<>();
        List<Colaborador> lstColaboradoresRETORNO = new ArrayList<>();
    
    }
    
}
