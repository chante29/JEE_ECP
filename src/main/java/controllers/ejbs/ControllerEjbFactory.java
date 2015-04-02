package controllers.ejbs;

import controllers.AniadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;
import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.jpa.DaoJpaFactory;

public class ControllerEjbFactory extends ControllerFactory {

	private AniadirTemaController aniadirTemaController;
	private EliminarTemaController eliminarTemaController;
	private VerVotacionesController verVotacionesController;
	private VotarController votarController;
	
	public ControllerEjbFactory(){
		DAOFactory.setFactory(new DaoJpaFactory());
	}
	@Override
	public AniadirTemaController getAniadirTemaController() {
		
		return aniadirTemaController == null ? new AniadirTemaControllerEjb() : aniadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController == null ? new EliminarTemaControllerEjb() : eliminarTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		
		return verVotacionesController == null ? new VerVotacionesControllerEjb() : verVotacionesController;
	}

	@Override
	public VotarController getVotarController() {
		return votarController == null ? new VotarControllerEjb() : votarController;
	}

}
