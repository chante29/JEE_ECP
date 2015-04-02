package controllers;

import java.util.List;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;

public interface VotarController {
	List<Tema> getAllTemas();
	void aniadirVoto(Tema tema, Voto voto);
	NivelEstudios[] getAllNivelesEstudios();
	Tema getTema(Integer id);
}
