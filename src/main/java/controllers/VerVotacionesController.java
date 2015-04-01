package controllers;

import java.util.HashMap;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;

public interface VerVotacionesController {

	int getNumeroVotos(Tema tema);
	HashMap<NivelEstudios, Float> getMediaPorNivelEstudios(Tema tema);
}
