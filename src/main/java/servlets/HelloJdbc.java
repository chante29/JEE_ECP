package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloJdbc")
public class HelloJdbc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        String salida = "";
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet result = null;
        String bd = request.getParameter("bd");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String url = "jdbc:mysql://localhost:3306/"+bd;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            sentencia = conexion.createStatement();
        } catch (ClassNotFoundException e) {
            error += "Imposible cargar el driver:<br /> " + e.getMessage() + "<br />";
        } catch (SQLException e) {
            error += "Imposible conectar:<br /> " + e.getMessage() + "<br />";
        }

        if (error.equals("")) {
            try {
                sentencia.executeUpdate("DROP TABLE IF EXISTS user");
                sentencia
                        .executeUpdate("CREATE TABLE user (ID INT PRIMARY KEY, NAME CHAR(20) DEFAULT '-')");

            } catch (SQLException e) {
                error += "Creación de tabla fallida:<br /> " + e.getMessage() + "<br />";
            }
        }

        if (error.equals("")) {
            try {
                sentencia.executeUpdate("INSERT user (id) VALUES (1)");
                sentencia.executeUpdate("INSERT user VALUES (2,'Funciona')");
                sentencia.executeUpdate("INSERT user VALUES (3,'Bien')");
            } catch (SQLException e) {
                error += "Insercción de datos de tabla fallida:<br /> " + e.getMessage() + "<br />";
            }
        }

        if (error.equals("")) {
            try {
                result = sentencia.executeQuery("SELECT * FROM user");
                while (result.next())
                    salida += "id: " + result.getLong("ID") + ", name: "
                            + result.getString("NAME") + "<br />";
            } catch (SQLException e) {
                error += "Consulta Fallida: " + e.getMessage() + "<br />";
            }
        }

        if (error.equals("")) error="Sin errores";
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
