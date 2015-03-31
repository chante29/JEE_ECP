package utils;
import java.util.ArrayList;
import java.util.Iterator;

import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;
public class ArrayToListTransformer {

	public static Iterator<Tema> transform(String[] nombresTema, String[] preguntas, String[][][] votos){
		assert nombresTema.length == preguntas.length;
		assert preguntas.length == votos[0].length;
		ArrayList<Tema> temas = new ArrayList<Tema>();
		ArrayList<Voto> votos_tema;
		for (int numTema = 0; numTema < nombresTema.length; numTema++) {
			votos_tema = votos[numTema] == null ? null : votosTema(votos[numTema]);
			temas.add(new Tema(nombresTema[numTema], preguntas[numTema],
					votos_tema));
		}
		return temas.iterator();
		
	}

	private static ArrayList<Voto> votosTema(String[][] votos) {
		ArrayList<Voto> votos_tema = new ArrayList<Voto>();
		for (int voto = 0; voto < votos.length; voto++) {
			Voto votoAux = new Voto(
					Integer.parseInt(votos[voto][0]), votos[voto][1],
					NivelEstudios.valueOf(votos[voto][2]));
			votos_tema.add(votoAux);
		}
		return votos_tema;
	}
}
