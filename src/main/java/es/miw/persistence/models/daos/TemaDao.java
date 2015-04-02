package es.miw.persistence.models.daos;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;


public interface TemaDao extends GenericDao<Tema, Integer>{

	boolean existeTema(String nombre_tema);
	
	float mediaPorNivelEstudios(Integer id_tema, NivelEstudios nivelEstudio);
}
