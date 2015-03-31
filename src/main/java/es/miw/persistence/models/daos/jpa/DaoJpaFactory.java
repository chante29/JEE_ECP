package es.miw.persistence.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.miw.persistence.models.daos.DAOFactory;
import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.daos.VotoDao;


public class DaoJpaFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "miwjee";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
    public static void prepareFactoryWithDropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
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
