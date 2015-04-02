package controllers.ejbs;

import controllers.EliminarTemaController;
import es.miw.persistence.models.daos.DAOFactory;

public class EliminarTemaControllerEjb implements EliminarTemaController {

	@Override
	public boolean autorizacionCorrecta(String identificador) {
		try {
			Integer intToken = Integer.parseInt(identificador);
			return intToken == 666;
			
		  } catch (NumberFormatException e) {
		    return false;
		  }
	}

	@Override
	public void eliminarTema(Integer id) {
		DAOFactory.getFactory().getTemaDao().deleteById(id);
	}

}
