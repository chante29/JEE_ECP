package es.miw.persistence.models.daos.jpa;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.utils.NivelEstudios;

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

	@Override
	public HashMap<NivelEstudios, Double> mediasPorNivelEstudios(Integer id_tema) {
		
			EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
					.createEntityManager();
			CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
			CriteriaQuery<Tuple> criteriaQuery = criteria.createQuery(Tuple.class);
			Root<Tema> temas = criteriaQuery.from(Tema.class);
			Path<Object> path = temas.join("votos");
			CriteriaQuery<Tuple> select = criteriaQuery.select(criteria.tuple(path.get("nivel_estudios"), criteria.avg(path.get("valoracion"))));
			select.where(criteria.equal(temas.get("id"), id_tema));
			select.groupBy(path.get("nivel_estudios"));
			List<Tuple> result = entityManager.createQuery(select).getResultList();
			return this.getMediaVotos(result);
	}

	private HashMap<NivelEstudios, Double> getMediaVotos(List<Tuple> votos) {
		HashMap<NivelEstudios, Double> medias = new HashMap<NivelEstudios, Double> ();
		for (Tuple voto : votos) {
			medias.put(NivelEstudios.valueOf(String.valueOf(voto.get(0))), Double.parseDouble(String.valueOf(voto.get(1))));
		}
		return medias;
	}
			
			
	
}
