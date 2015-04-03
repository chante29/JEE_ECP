package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

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
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>() {
        };
        List<Tema> temas =  ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
        for (Tema temaExiste : temas) {
			if(tema.getNombre_tema().equals(temaExiste.getNombre_tema())){
				return true;
			}
		}
        return false;
	}

}
