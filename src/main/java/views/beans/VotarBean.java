package views.beans;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.persistence.models.entities.Tema;

public class VotarBean extends GenericBean {
	private static final long serialVersionUID = 1L;
	List<Tema> temas;
	
	public VotarBean(){
		temas = cargarTemasDeBBDD();
	}
	
	public void update() {
        LogManager.getLogger(VotarBean.class).debug(
                "Se accede a la capa de negocio para recuperar temas");
        this.temas = null;
    }

	private List<Tema> cargarTemasDeBBDD() {
		
		return DaoJpaFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public String process() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
