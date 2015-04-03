package es.miw.persistence.models.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@Entity 
@XmlRootElement
public class Tema {
	public static final String TABLE = "tema";

    public static final String ID = "ID";
    
	@Id
    @GeneratedValue
    private Integer id;
	
	public static final String NOMBRE_TEMA = "nombre_tema";
	
	private String nombre_tema;
	
	public static final String PREGUNTA = "pregunta";
	
	private String pregunta;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Voto> votos;

	
	public Tema() {
		super();
	}

	public Tema(String nombre_tema, String pregunta,
			List<Voto> votos) {
		super();
		this.nombre_tema = nombre_tema;
		this.pregunta = pregunta;
		this.votos = votos;
	}

	public Tema(String nombre_tema, String pregunta) {
		super();
		this.nombre_tema = nombre_tema;
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_tema() {
		return nombre_tema;
	}

	public void setNombre_tema(String nombre_tema) {
		this.nombre_tema = nombre_tema;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nombre_tema=" + nombre_tema
				+ ", pregunta=" + pregunta + ", votos=" + votos + "]";
	}

	@Override
	public boolean equals(Object object){
		if (this.getClass() != object.getClass())
            return false;
		Tema temaObject = (Tema) object;
		if(this.id == temaObject.id && this.nombre_tema.equals(temaObject.nombre_tema)
                && pregunta.equals(temaObject.pregunta))
			return true;
		return false;
	}
	
	
}
