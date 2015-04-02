package controllers.ejbs;

import java.util.HashMap;

import controllers.VerVotacionesController;
import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	@Override
	public int getNumeroVotos(Tema tema) {
		return tema.getVotos().size();
	}

	@Override
	public HashMap<NivelEstudios, Double> getMediaPorNivelEstudios(Tema tema) {
		return DAOFactory.getFactory().getTemaDao().mediasPorNivelEstudios(tema.getId());
	}

}
