package controllers.ejbs;

import java.util.ArrayList;
import java.util.List;

import controllers.VotarController;
import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;
public class VotarControllerEjb implements VotarController{

	@Override
	public List<Tema> getAllTemas() {
		return DAOFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public void aniadirVoto(Tema tema, Voto voto) {
		List<Voto> votos = tema.getVotos();
		if(votos == null){
			votos = new ArrayList<Voto>();
		}
		votos.add(voto);
		tema.setVotos(votos);
		DAOFactory.getFactory().getTemaDao().update(tema);
		
	}

	@Override
	public NivelEstudios[] getAllNivelesEstudios() {
		return NivelEstudios.values();
	}

	@Override
	public Tema getTema(Integer id) {
		return DAOFactory.getFactory().getTemaDao().read(id);
	}

	@Override
	public Voto crearVoto(Integer valoracion, String IP,
			NivelEstudios nivel_estudios) {
		 
		return new Voto(valoracion, IP, nivel_estudios);
	}

}
