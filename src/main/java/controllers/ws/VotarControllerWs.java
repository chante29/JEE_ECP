package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import ws.TemaUris;
import ws.VotoUris;
import controllers.VotarController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;

public class VotarControllerWs implements VotarController{

	@Override
	public List<Tema> getAllTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>() {
        };
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

	@Override
	public void aniadirVoto(Tema tema, Voto voto) {
		ControllerWs.buildWebServiceManager(VotoUris.PATH_VOTOS, tema.getId().toString()).create();
		
	}

	@Override
	public NivelEstudios[] getAllNivelesEstudios() {
		GenericType<NivelEstudios[]> genericType = new GenericType<NivelEstudios[]>() {
        };
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entitiesArray(genericType);
	}

	@Override
	public Tema getTema(Integer id) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).entity(Tema.class);
		return null;
	}

	@Override
	public Voto crearVoto(Integer valoracion, String IP,
			NivelEstudios nivel_estudios) {
		
		return new Voto(valoracion, IP, nivel_estudios);
	}

}
