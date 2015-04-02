package controllers;

import es.miw.persistence.models.entities.Tema;

public interface AniadirTemaController {
	void aniadirTema(Tema tema);
	
	boolean existeTema(Tema tema); 
}
