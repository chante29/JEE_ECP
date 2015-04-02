package es.miw.persistence.models.daos;

import java.util.HashMap;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;


public interface TemaDao extends GenericDao<Tema, Integer>{

	boolean existeTema(String nombre_tema);
	
	HashMap<NivelEstudios, Double> mediasPorNivelEstudios(Integer id_tema);
}
