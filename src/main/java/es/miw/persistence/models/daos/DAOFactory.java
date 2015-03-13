package es.miw.persistence.models.daos;



public abstract class DAOFactory {
	public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
    	DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        assert factory != null;
        return factory;
    }

}
