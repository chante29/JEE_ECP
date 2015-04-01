package controllers.ejbs;

import java.util.List;

import controllers.VotarController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
public class VotarControllerEjb implements VotarController{

	@Override
	public List<Tema> getAllTemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aniadirVoto(Tema tema, Voto voto) {
		// TODO Auto-generated method stub
		return false;
	}

}
