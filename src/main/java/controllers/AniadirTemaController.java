package controllers;

import es.miw.persistence.models.entities.Tema;

public interface AniadirTemaController {
	boolean aniadirTema(Tema tema);
	
	boolean existeTema(Tema tema); 
}
