package controllers.ws;

import java.util.HashMap;

import controllers.VerVotacionesController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;

public class VerVotacionesControllerWs implements VerVotacionesController {

	@Override
	public int getNumeroVotos(Tema tema) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap<NivelEstudios, Double> getMediaPorNivelEstudios(Tema tema) {
		// TODO Auto-generated method stub
		return null;
	}

}
