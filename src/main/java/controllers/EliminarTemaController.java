package controllers;

public interface EliminarTemaController {
	boolean autorizacionCorrecta(String identificador);
	void eliminarTema(Integer id);
	
}
