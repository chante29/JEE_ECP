package models.daos.jpa.data;

import java.util.Iterator;

import utils.ArrayToListTransformer;
import es.miw.persistence.models.entities.Tema;

public class TemaDaoJpaTestData {

	private String[] nombreTema = { "Historia", "Matemáticas", "Geografía", "Dibujo técnico", "Lenguaje"};

	private String[] pregunta = { "¿Qué nivel de historia española consideras que tienes?",
			"¿Qué conocimientos de resolver integrales consideras que posees?", "¿Qué conocimientos de los ríos de España tienes?",
			"¿Qué nivel de uso de la escuadra y el cartabón posees?", "¿Qué nivel de sintaxis de oraciones posees?" };
	private String[][][] votos = {
			{ { "9", "192.168.1.1", "UNIVERSIDAD" },
					{ "7", "192.168.1.2", "BACHILLERATO" },
					{ "4", "192.168.1.3", "SECUNDARIA" } },
			null,
			{ { "4", "192.168.1.4", "PRIMARIA" },
					{ "9", "192.168.1.5", "UNIVERSIDAD" },
					{ "6", "192.168.1.6", "BACHILLERATO" },
					{ "3", "192.168.1.7", "SECUNDARIA" } },
					
			{ { "7", "192.168.1.8", "BACHILLERATO" } } ,
					
	{{"1", "192.168.1.9", "PRIMARIA"},
		{"6", "192.168.1.10", "UNIVERSIDAD"}}};

  
    private Iterator<Tema> temasIterator;

    private Tema tema;

    public TemaDaoJpaTestData() {
		temasIterator = ArrayToListTransformer.transform(nombreTema, pregunta,
				votos);
		this.nextTema();
	}

	public boolean hasNextTemas() {
		return temasIterator.hasNext();
	}

	public void nextTema() {
		tema = temasIterator.next();
	}

	public Tema getTema() {
		return tema;
	}

}
