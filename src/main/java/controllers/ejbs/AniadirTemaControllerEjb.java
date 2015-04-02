package controllers.ejbs;

import controllers.AniadirTemaController;
import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.entities.Tema;

public class AniadirTemaControllerEjb implements AniadirTemaController {

	@Override
	public void aniadirTema(Tema tema) {
		DAOFactory.getFactory().getTemaDao().create(tema);
	}

	@Override
	public boolean existeTema(Tema tema) {		
		return DAOFactory.getFactory().getTemaDao().existeTema(tema.getNombre_tema());
	}

}
