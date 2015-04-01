package controllers;

public interface EliminarTemaController {
	boolean autorizacionCorrecta(String identificador);
	boolean eliminarTema(Integer id);
	
}
