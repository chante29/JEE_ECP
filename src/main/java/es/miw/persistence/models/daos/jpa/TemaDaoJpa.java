package es.miw.persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
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
	public float mediaPorNivelEstudios(Integer id_tema,
			NivelEstudios nivelEstudio) {
			EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
					.createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Voto> query = builder.createQuery(Voto.class);
			Root<Tema> root = query.from(Tema.class);
			query.select(root.get("votos"));
			Predicate p1 = builder.equal(root.get("id").as(Integer.class),
					id_tema);
			Predicate p2 = builder.equal(root.get("votos").get("nivel_estudios").as(NivelEstudios.class),
					nivelEstudio);
			Predicate predicate = builder.and(p1, p2);
			query.where(predicate);
			TypedQuery<Voto> typedQuery = entityManager.createQuery(query);
			List<Voto> result = typedQuery.getResultList();
			entityManager.close();
			return this.getMediaVotos(result);
	}

	private float getMediaVotos(List<Voto> votos) {
		float media = 0;
		for (Voto voto : votos) {
			media += voto.getValoracion();
		}
		return media / votos.size();
	}
			
			
	
}
