package controllers;

public abstract class ControllerFactory {
	public abstract AniadirTemaController getAniadirTemaController();
	public abstract EliminarTemaController getEliminarTemaController();
	public abstract VerVotacionesController getVerVotacionesController();
	public abstract VotarController getVotarController();
	
}
