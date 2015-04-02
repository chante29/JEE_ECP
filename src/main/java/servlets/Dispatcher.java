package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    /**
     * @see HttpServlet#HttpServlet()
     *//*
    public Dispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see Servlet#init(ServletConfig)
	 *//*
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	*//**
	 * @see Servlet#getServletConfig()
	 *//*
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "Home";
		switch (action) {
        case "Votar":
            VotarBean votarBean = new VotarBean();
            /*personaView.setPersona(new Persona());*/
            request.setAttribute(action, votarBean);
            view = action;
            break;
        case "VerVotaciones":
            VerVotacionesBean verVotacionesBean = new VerVotacionesBean();
            request.setAttribute(action, verVotacionesBean);
            view = action;
            break;
        case "AniadirTema":
        	AniadirTemaBean aniadirTemaBean = new AniadirTemaBean();
        	request.setAttribute(action, aniadirTemaBean);
        	view = action;
        	break;
        case "EliminarTema":
        	EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
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