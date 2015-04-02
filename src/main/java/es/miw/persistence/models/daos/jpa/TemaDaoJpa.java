package es.miw.persistence.models.daos.jpa;

import java.util.List;

import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer > implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

	@Override
	public boolean existeTema(String nombre_tema) {
		List<Tema> temas = this.findAll();
		for (Tema tema : temas) {
			if(tema.getNombre_tema().equals(nombre_tema))
				return true;
		}
		return false;
	}

}
