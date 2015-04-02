package views.beans;

import java.util.HashMap;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;;

public class VerVotacionesBean extends ListaTemasBean {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_VER_VOTACIONES= "VerVotaciones";
	private Integer numVotos;
	
	private HashMap<NivelEstudios, Float> medias;
	
	private NivelEstudios[] niveles_estudios;
	
	private Tema tema;

	@Override
	public String process() {
		if(tema != null){
			this.niveles_estudios = this.getControllerFactory().getVotarController().getAllNivelesEstudios();
			this.numVotos = this.getControllerFactory().getVerVotacionesController().getNumeroVotos(tema);
			this.medias = this.getControllerFactory().getVerVotacionesController().getMediaPorNivelEstudios(tema);
			
		}

		return VISTA_VER_VOTACIONES;
	}


	@Override
	public void recogerDatosUpdate() {
		// TODO Auto-generated method stub
	}


	public Integer getNumVotos() {
		return numVotos;
	}


	public void setNumVotos(Integer numVotos) {
		this.numVotos = numVotos;
	}


	public HashMap<NivelEstudios, Float> getMedias() {
		return medias;
	}


	public void setMedias(HashMap<NivelEstudios, Float> medias) {
		this.medias = medias;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Integer id_tema) {
		this.tema = this.getControllerFactory().getVotarController().getTema(id_tema);
	}


	public NivelEstudios[] getNiveles_estudios() {
		return niveles_estudios;
	}


	public void setNiveles_estudios(NivelEstudios[] niveles_estudios) {
		this.niveles_estudios = niveles_estudios;
	}



	
}
