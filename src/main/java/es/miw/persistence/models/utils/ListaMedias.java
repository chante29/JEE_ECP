package es.miw.persistence.models.utils;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaMedias {
	private HashMap<NivelEstudios, Double> listaMedias;

	public ListaMedias(HashMap<NivelEstudios, Double> listaMedias) {
		super();
		this.listaMedias = listaMedias;
	}
	
	public ListaMedias(){
		
	}

	public HashMap<NivelEstudios, Double> getListaMedias() {
		if(this.listaMedias == null)
			listaMedias = new HashMap<NivelEstudios, Double>();
		return listaMedias;
	}

	public void setListaMedias(HashMap<NivelEstudios, Double> listaMedias) {
		this.listaMedias = listaMedias;
	}

	
	
}
