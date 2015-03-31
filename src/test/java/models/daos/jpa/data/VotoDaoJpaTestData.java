package models.daos.jpa.data;

import java.util.Iterator;

import utils.ArrayToListTransformer;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;

public class VotoDaoJpaTestData {
	private Integer[] valoraciones = {0, 1,2,3,4,5,6,7,8,9,10 };
	private String[] ips = { "192.168.1.0", "192.168.1.1", "192.168.1.2", "192.168.1.3",
			"192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7",
			"192.168.1.8", "192.168.1.9",
			"192.168.1.10" };
	private NivelEstudios[] nivelEstudios = { NivelEstudios.PRIMARIA,
			NivelEstudios.PRIMARIA, NivelEstudios.PRIMARIA,
			NivelEstudios.PRIMARIA, NivelEstudios.SECUNDARIA, NivelEstudios.SECUNDARIA, NivelEstudios.BACHILLERATO,
			NivelEstudios.BACHILLERATO, NivelEstudios.UNIVERSIDAD,
			NivelEstudios.UNIVERSIDAD, NivelEstudios.UNIVERSIDAD  };

	private Iterator<Voto> votosIterator;

	private Voto voto;

	public VotoDaoJpaTestData() {
		votosIterator = ArrayToListTransformer.transform(valoraciones, ips, nivelEstudios);
		this.nextVoto();
	}

	public boolean hasNextVotos() {
		return votosIterator.hasNext();
	}

	public void nextVoto() {
		voto = votosIterator.next();
	}

	public Voto getVoto() {
		return voto;
	}
}
