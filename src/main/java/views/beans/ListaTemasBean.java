package views.beans;

import java.util.List;

import es.miw.persistence.models.entities.Tema;

public abstract class ListaTemasBean extends GenericBean {
	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	
	public void update(){
		this.temas = this.getControllerFactory().getVotarController().getAllTemas();
		recogerDatosUpdate();
	}
	
	public abstract void recogerDatosUpdate();
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
}
