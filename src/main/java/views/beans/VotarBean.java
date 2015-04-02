package views.beans;


import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;
public class VotarBean extends ListaTemasBean {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_VOTAR= "Votar";
	
	private Tema tema;
	private Integer valoracion;
	private NivelEstudios[] nivelEstudios;
	private NivelEstudios nivelEstudio;
	private String ip;
	@Override
	public String process() {
		if(valoracion != null){
			this.getControllerFactory().getVotarController().aniadirVoto(tema, crearVoto());
		}
		return VISTA_VOTAR;
	}
	
	private Voto crearVoto(){
		return null;
	}

	@Override
	public void recogerDatosUpdate() {
		nivelEstudios = this.getControllerFactory().getVotarController().getAllNivelesEstudios();
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Integer id_tema) {
		this.tema = this.getControllerFactory().getVotarController().getTema(id_tema);
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public NivelEstudios[] getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios[] nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public NivelEstudios getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(NivelEstudios nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
