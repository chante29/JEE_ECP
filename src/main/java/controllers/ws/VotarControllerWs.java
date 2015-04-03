package controllers.ws;

import java.util.List;

import controllers.VotarController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;

public class VotarControllerWs implements VotarController{

	@Override
	public List<Tema> getAllTemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aniadirVoto(Tema tema, Voto voto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NivelEstudios[] getAllNivelesEstudios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema getTema(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voto crearVoto(Integer valoracion, String IP,
			NivelEstudios nivel_estudios) {
		// TODO Auto-generated method stub
		return null;
	}

}
