package es.miw.persistence.models.daos;

import es.miw.persistence.models.entities.Tema;


public interface TemaDao extends GenericDao<Tema, Integer>{

	boolean existeTema(String nombre_tema);
}
