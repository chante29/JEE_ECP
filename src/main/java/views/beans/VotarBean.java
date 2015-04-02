package views.beans;


import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;
public class VotarBean extends ListaTemasBean {
	private static final long serialVersionUID = 1L;
	
	private Tema tema;
	private int valoracion;
	private NivelEstudios[] nivelEstudios;
	@Override
	public String process() {
		// TODO Auto-generated method stub
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
	
}
