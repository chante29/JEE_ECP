package ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.persistence.models.entities.Voto;
import ws.VotoUris;

@Path(VotoUris.PATH_VOTOS)
public class VotoResource {

	private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(VotoUris.PATH_VOTOS + msg);
    }
	
	public VotoResource(){
		DAOFactory.setFactory(new DaoJpaFactory());
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Voto voto) {
        DAOFactory.getFactory().getVotoDao().create(voto);
        this.debug("POST/" + VotoUris.PATH_VOTOS + "/ " + voto);
        return Response.created(URI.create(VotoUris.PATH_VOTOS + "/" + voto.getValoracion()))
                .entity(voto.getId()).build();
    }
	
	@GET
    @Path(VotoUris.PATH_ID_PARAM)
    @Produces(MediaType.APPLICATION_XML)
    public Voto get(@PathParam("id") Integer id) {
        Voto voto = DAOFactory.getFactory().getVotoDao().read(id);
        this.debug("GET/" + VotoUris.PATH_VOTOS + "/" + id + "= " + voto);
        return voto;
    }

	@PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(Voto voto) {
        DAOFactory.getFactory().getVotoDao().update(voto);
        this.debug("PUT/" + VotoUris.PATH_VOTOS + "= " + voto);
        return Response.created(URI.create(VotoUris.PATH_VOTOS + "/" + voto.getId()))
                .entity(voto.getId()).build();
    }

}
