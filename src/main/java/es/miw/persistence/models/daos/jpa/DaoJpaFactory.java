package es.miw.persistence.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.daos.VotoDao;


public class DaoJpaFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "temasvotados";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public TemaDao getTemaDao() {
        return new TemaDaoJpa();
    }
    
    @Override
    public VotoDao getVotoDao() {
        return new VotoDaoJpa();
    }


}
