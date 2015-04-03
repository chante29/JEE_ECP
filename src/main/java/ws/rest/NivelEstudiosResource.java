package ws.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.miw.persistence.models.utils.ListaNivelEstudios;
import es.miw.persistence.models.utils.NivelEstudios;
import ws.NivelEstudiosUri;

@Path(NivelEstudiosUri.PATH_NIVELES)
public class NivelEstudiosResource {

	@GET
    @Produces(MediaType.APPLICATION_XML)
    public ListaNivelEstudios findAll() {
		List<String> nivelesEstudios = new ArrayList<String>();
		for(NivelEstudios nivelEstudios : NivelEstudios.values()) {
			nivelesEstudios.add(nivelEstudios.toString());
		}
		return new ListaNivelEstudios(nivelesEstudios);
    }
}
