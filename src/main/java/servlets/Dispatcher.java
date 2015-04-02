package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ControllerFactory;
import controllers.ejbs.ControllerEjbFactory;
import views.beans.AniadirTemaBean;
import views.beans.EliminarTemaBean;
import views.beans.VerVotacionesBean;
import views.beans.VotarBean;


/**
 * Servlet implementation class Dispatcher
 */
@WebServlet(description = "Repartidor de funcionalidad", urlPatterns = { "/jsp/*" })
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String PATH_ROOT_VIEW = "/views/";
    
	private ControllerFactory controllerFactory;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.controllerFactory = new ControllerEjbFactory();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "Home";
		switch (action) {
        case "Votar":
            VotarBean votarBean = new VotarBean();
            votarBean.setControllerFactory(this.controllerFactory);
            /*personaView.setPersona(new Persona());*/
            votarBean.update();
            request.setAttribute(action, votarBean);
            view = action;
            break;
        case "VerVotaciones":
            VerVotacionesBean verVotacionesBean = new VerVotacionesBean();
            verVotacionesBean.setControllerFactory(this.controllerFactory);
            request.setAttribute(action, verVotacionesBean);
            view = action;
            break;
        case "AniadirTema":
        	AniadirTemaBean aniadirTemaBean = new AniadirTemaBean();
        	aniadirTemaBean.setControllerFactory(this.controllerFactory);
        	request.setAttribute(action, aniadirTemaBean);
        	view = action;
        	break;
        case "EliminarTema":
        	EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
        	eliminarTemaBean.setControllerFactory(this.controllerFactory);
        	request.setAttribute(action, eliminarTemaBean);
        	view = action;
        	break;
        default:
            view = "Home";
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
