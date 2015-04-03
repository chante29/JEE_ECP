package controllers.ws;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.GenericType;

import ws.TemaUris;
import ws.VotoUris;
import controllers.VerVotacionesController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;

public class VerVotacionesControllerWs implements VerVotacionesController {

	@Override
	public int getNumeroVotos(Tema tema) {
		GenericType<List<Voto>> genericType = new GenericType<List<Voto>>() {
        };
		return ControllerWs.buildWebServiceManager(VotoUris.PATH_VOTOS).entities(genericType).size();
	}

	@Override
	public HashMap<NivelEstudios, Double> getMediaPorNivelEstudios(Tema tema) {
		GenericType<HashMap<NivelEstudios, Double>> genericType = new GenericType<HashMap<NivelEstudios, Double>>() {
        };
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, TemaUris.PATH_MEDIAS, tema.getId().toString()).entitiesHashMap(genericType);

	}

}
