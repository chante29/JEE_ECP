package views.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistence.models.entities.Tema;

public class VotarBean extends GenericBean {
	private static final long serialVersionUID = 1L;
	private List<Tema> temas;
	
	public VotarBean(){
	}
	
	public void update() {
        LogManager.getLogger(VotarBean.class).debug(
                "Se accede a la capa de negocio para recuperar temas");
        this.temas = this.getControllerFactory().getVotarController().getAllTemas();
    }

	@Override
	public String process() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	
}
