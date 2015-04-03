package controllers.ws;

import java.util.HashMap;
import ws.TemaUris;
import controllers.VerVotacionesController;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.ListaMedias;
import es.miw.persistence.models.utils.NivelEstudios;

public class VerVotacionesControllerWs implements VerVotacionesController {

	@Override
	public int getNumeroVotos(Tema tema) {
		
		
        Tema temaRecuperado = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getId().toString()).entity(Tema.class);
        
		return temaRecuperado.getVotos().size();
	}

	@Override
	public HashMap<NivelEstudios, Double> getMediaPorNivelEstudios(Tema tema) {
		ListaMedias listaMedias = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, TemaUris.PATH_MEDIAS, tema.getId().toString()).entity(ListaMedias.class);
		return listaMedias.getListaMedias();		
	}

}
