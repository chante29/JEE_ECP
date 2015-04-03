package ws.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ws.TemaUris;

import org.apache.logging.log4j.LogManager;

import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;


@Path(TemaUris.PATH_TEMAS)
public class TemaResource {
	
    private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
    }

    public TemaResource (){
    	DAOFactory.setFactory(new DaoJpaFactory());
    }
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Tema tema) {
        this.debug(" POST/ " + TemaUris.PATH_TEMAS + " \nTema Creado = " + tema.toString());
        DAOFactory.getFactory().getTemaDao().create(tema);
        return Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
                .entity(String.valueOf(tema.getId())).build();
    }

    @Path(TemaUris.PATH_ID_PARAM)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Tema get(@PathParam("id") Integer id) {
        Tema tema = DAOFactory.getFactory().getTemaDao().read(id);
        this.debug("/" + TemaUris.PATH_TEMAS + "/" + id + " /GETTEMA: " + tema);
        return tema;
    }

    @Path(TemaUris.PATH_TEMAS)
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(Tema tema) {
        DAOFactory.getFactory().getTemaDao().update(tema);
        this.debug("/" + tema.getId() + "/"+ TemaUris.PATH_TEMAS + " /PUTTEMA: " + tema);
       return Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
       			.entity(tema.getId()).build(); 
    }

    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Tema> findAll() {
        this.debug(TemaUris.PATH_TEMAS + " /GETAlls ");
        return DAOFactory.getFactory().getTemaDao().findAll();
    }

    @Path(TemaUris.PATH_ID_PARAM)
    @DELETE
    public void delete(@PathParam("id") Integer id) {
    	DAOFactory.getFactory().getTemaDao().deleteById(id);
        this.debug("/" +TemaUris.PATH_ID_PARAM + "/" + id + " /DELETE");
    }

    @Path(TemaUris.PATH_MEDIAS + TemaUris.PATH_ID_PARAM)
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public HashMap<NivelEstudios, Double> mediasPorNivelEstudios(@PathParam("id") Integer id) {
        this.debug("/"+ TemaUris.PATH_TEMAS + "/" + TemaUris.PATH_MEDIAS + "/" + id + "/GETMEDIAS:");
        return DAOFactory.getFactory().getTemaDao().mediasPorNivelEstudios(id);
    }


}