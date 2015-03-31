package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.daos.jpa.data.TemaDaoJpaTestData;
import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.persistence.models.entities.Tema;

public class TemaDaoJpaTest {
	private TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();

	private TemaDaoJpaTestData datos;
	private List<Tema> datosTemas ;

	@BeforeClass
	public static void beforeClass() {
		DAOFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

	@Before
	public void init() {
		datos = new TemaDaoJpaTestData();
		datosTemas = new ArrayList<Tema>();
		while (datos.hasNextTemas()) {
			if (datos.getTema() != null) {
				temaDao.create(datos.getTema());
				datosTemas.add(datos.getTema());
			}
			datos.nextTema();
		}
		temaDao.create(datos.getTema());
		datosTemas.add(datos.getTema());
	}

	@After
	public void finish() {
		List<Tema> temas = temaDao.findAll();
		for (Tema tema : temas) {
			temaDao.deleteById(tema.getId());
		}
	}


	@Test
	public void testCreate() {
		List<Tema> temas = temaDao.findAll();
		for (Tema tema : datosTemas) {
			assertTrue(temas.contains(tema));
		}
		assertTrue(temas.size() == datosTemas.size());
	}

	@Test
	public void testRead() {
		for (Tema tema : datosTemas) {
			assertEquals(tema, temaDao.read(tema.getId()));
		}
	}

	@Test
	public void testUpdate() {
		Tema temaAux;
		for (Tema tema : datosTemas) {
			temaAux = temaDao.read(tema.getId());
			temaAux.setNombre_tema("Aux");
			temaDao.update(temaAux);
			assertNotEquals(tema, temaDao.read(tema.getId()));
		}
	}

	@Test
	public void testDeleteById() {
		for (Tema tema : datosTemas) {
			temaDao.deleteById(tema.getId());
		}
		assertTrue(temaDao.findAll().isEmpty());
	}

	@Test
	public void testFindAll() {
		List<Tema> temas = temaDao.findAll();
		for (Tema tema : datosTemas) {
			assertTrue(temas.contains(tema));
		}
		assertTrue(temas.size() == datosTemas.size());
	}
}
