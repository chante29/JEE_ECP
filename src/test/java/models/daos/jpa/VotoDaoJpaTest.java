package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.jpa.data.VotoDaoJpaTestData;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.VotoDao;
import es.miw.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.persistence.models.entities.Voto;

public class VotoDaoJpaTest {
	private VotoDao votoDao = DaoJpaFactory.getFactory().getVotoDao();

	private VotoDaoJpaTestData datos;
	private ArrayList<Voto> datosVotos = new ArrayList<Voto>();

	@BeforeClass
	public static void beforeClass() {
		DAOFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

	@Before
	public void init() {
		datos = new VotoDaoJpaTestData();
		datosVotos = new ArrayList<Voto>();
		while (datos.hasNextVotos()) {
			Voto votoAux = datos.getVoto();
			if (votoAux != null) {
				votoDao.create(votoAux);
				datosVotos.add(votoAux);
			}
			datos.nextVoto();
		}
		votoDao.create(datos.getVoto());
		datosVotos.add(datos.getVoto());
	}
	
	@After
	public void finish() {
		List<Voto> votos = votoDao.findAll();
		for(Voto voto : votos){
			votoDao.deleteById(voto.getId());
		}
	}

	@Test
	public void testCreate() {
		List<Voto> votos = votoDao.findAll();
		for (Voto voto : datosVotos) {
			assertTrue(votos.contains(voto));
		}
		assertTrue(votos.size() == datosVotos.size());
	}

	@Test
	public void testRead() {
		for (Voto voto : datosVotos) {
			assertEquals(voto, votoDao.read(voto.getId()));
		}
	}

	@Test
	public void testUpdate() {
		Voto votoAux;
		for (Voto voto : datosVotos) {
			votoAux = votoDao.read(voto.getId());
			votoAux.setValoracion(0);
			votoDao.update(votoAux);
			assertNotEquals(voto, votoDao.read(voto.getId()));
		}
	}

	@Test
	public void testDeleteById() {
		for (Voto voto : datosVotos) {
			votoDao.deleteById(voto.getId());
		}
		assertTrue(votoDao.findAll().isEmpty());
	}

	@Test
	public void testFindAll() {
		List<Voto> votos = votoDao.findAll();
		for (Voto voto : datosVotos) {
			assertTrue(votos.contains(voto));
		}
		assertTrue(votos.size() == datosVotos.size());
	}
}
