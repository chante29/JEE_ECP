package controllers.ejbs;

import java.util.List;

import controllers.VotarController;
import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
public class VotarControllerEjb implements VotarController{

	@Override
	public List<Tema> getAllTemas() {
		DAOFactory.setFactory(new DaoJpaFactory());
		return DaoJpaFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public boolean aniadirVoto(Tema tema, Voto voto) {
		// TODO Auto-generated method stub
		return false;
	}

}
