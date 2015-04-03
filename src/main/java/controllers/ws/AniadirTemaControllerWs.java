package controllers.ws;

import ws.TemaUris;
import controllers.AniadirTemaController;
import es.miw.persistence.models.entities.Tema;

public class AniadirTemaControllerWs implements AniadirTemaController{

	@Override
	public void aniadirTema(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);
		
	}

	@Override
	public boolean existeTema(Tema tema) {
		Tema temaDevuelto = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getId().toString()).entity(Tema.class);
		return temaDevuelto != null ? true : false;
	}

}
