package controllers;

import java.util.List;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;

public interface VotarController {
	List<Tema> getAllTemas();
	boolean aniadirVoto(Tema tema, Voto voto);
}