package controllers.ws;

import ws.TemaUris;
import controllers.EliminarTemaController;


public class EliminarTemaControllerWs implements EliminarTemaController {

	@Override
	public boolean autorizacionCorrecta(String identificador) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,TemaUris.PATH_AUTORIZACION,  identificador)
        .delete();
		return false;
	}

	@Override
	public void eliminarTema(Integer id) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString())
        .delete();
		
	}

}
