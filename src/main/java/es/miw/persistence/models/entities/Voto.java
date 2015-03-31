package es.miw.persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.miw.persistence.models.utils.NivelEstudios;

@Entity
public class Voto {
	public static final String TABLE = "voto";

    public static final String ID = "ID";

	@Id
    @GeneratedValue
    private Integer id;
	
	private Integer valoracion;
	
	private String IP;
	
	@Enumerated(EnumType.STRING)
	private NivelEstudios nivel_estudios;
	
	

	public Voto() {
		super();
	}

	public Voto(Integer valoracion, String iP,
			NivelEstudios nivel_estudios) {
		super();
		this.valoracion = valoracion;
		IP = iP;
		this.nivel_estudios = nivel_estudios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public NivelEstudios getNivel_estudios() {
		return nivel_estudios;
	}

	public void setNivel_estudios(NivelEstudios nivel_estudios) {
		this.nivel_estudios = nivel_estudios;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", valoracion=" + valoracion + ", IP=" + IP
				+ ", nivel_estudios=" + nivel_estudios + "]";
	}
	
	
}
