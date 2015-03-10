package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import entity.User;

@WebServlet("/HelloJpa")
public class HelloJpa extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        String salida = "";
        String bd = request.getParameter("bd");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String url = "jdbc:mysql://localhost:3306/" + bd;

        // Se borrar y se crean las tablas y se establece la conexión
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        properties.put("javax.persistence.jdbc.url", url);
        properties.put("javax.persistence.jdbc.user", user);
        properties.put("javax.persistence.jdbc.password", pass);

        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("JEE.ECP", properties)
                    .createEntityManager();
        } catch (Exception e) {
            error += e.getMessage();
        }

        // Create
        if (error.equals("")) {
            try {
                em.getTransaction().begin();
                em.persist(new User(1, ""));
                em.persist(new User(2, "Funciona"));
                em.persist(new User(3, "Bien"));
                em.getTransaction().commit();
            } catch (Exception e) {
            }
        }

        if (error.equals("")) {
            try {
                List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
                salida += users.toString();
            } catch (Exception e) {
                error += e.getMessage();
            }
        }
        
        if (error.equals(""))
            error = "Sin errores, OK!!!";
        // Salida
        String web = "<html><head><title>Prueba JDBC</title></head>"
                + "<body> <h1>Prueba JDBC</h1>";
        web += "<h2>Errores</h2><p>" + error + "</p>";
        web += "<h2>Salida</h2><p>" + salida + "</p>";
        web += "<p><a href='index.html'>Volver</a></p>";
        web += "</body></html>";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(web);

    }

}
