package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import ws.NivelEstudiosUri;
import ws.TemaUris;
import ws.VotoUris;
import controllers.VotarController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.ListaNivelEstudios;
import es.miw.persistence.models.utils.NivelEstudios;

public class VotarControllerWs implements VotarController{

	@Override
	public List<Tema> getAllTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>() {
        };
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

	@Override
	public void aniadirVoto(Tema tema, Voto voto) {
		ControllerWs.buildWebServiceManager(VotoUris.PATH_VOTOS, VotoUris.PATH_VOTO,"/", tema.getId().toString()).create(voto);
		
	}

	@Override
	public NivelEstudios[] getAllNivelesEstudios() {
		ListaNivelEstudios listaNiveles = ControllerWs.buildWebServiceManager(NivelEstudiosUri.PATH_NIVELES).entity(ListaNivelEstudios.class);
		NivelEstudios[] nivelesEstudio = new NivelEstudios[listaNiveles.getListaNivelEstudios().size()];
		for (int nivelEstudio = 0; nivelEstudio < nivelesEstudio.length; nivelEstudio++) {
			nivelesEstudio[nivelEstudio] = NivelEstudios.valueOf(listaNiveles.getListaNivelEstudios().get(nivelEstudio));
		}
		return nivelesEstudio;
	}

	@Override
	public Tema getTema(Integer id) {
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).entity(Tema.class);

	}

	@Override
	public Voto crearVoto(Integer valoracion, String IP,
			NivelEstudios nivel_estudios) {
		
		return new Voto(valoracion, IP, nivel_estudios);
	}

}
