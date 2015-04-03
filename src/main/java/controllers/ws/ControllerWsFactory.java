package controllers.ws;

import controllers.AniadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;


public class ControllerWsFactory extends ControllerFactory{
	private AniadirTemaController aniadirTemaController;
	private EliminarTemaController eliminarTemaController;
	private VerVotacionesController verVotacionesController;
	private VotarController votarController;


	@Override
	public AniadirTemaController getAniadirTemaController() {
		return aniadirTemaController == null ? new AniadirTemaControllerWs() : aniadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController == null ? new EliminarTemaControllerWs() : eliminarTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		
		return verVotacionesController == null ? new VerVotacionesControllerWs() : verVotacionesController;
	}

	@Override
	public VotarController getVotarController() {
		return votarController == null ? new VotarControllerWs() : votarController;
	}

    
}
