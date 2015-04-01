package controllers.ejbs;

import controllers.AniadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory {

	private AniadirTemaController aniadirTemaController;
	private EliminarTemaController eliminarTemaController;
	private VerVotacionesController verVotacionesController;
	private VotarController votarController;
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
