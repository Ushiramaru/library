package dao.factory;

import dao.EditionDAO;
import dao.UserDAO;
import dao.impl.*;

/**
 * The type Dao factory.
 */
public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final EditionDAO xmlPrintEditionDAO = new XMLEditionDAO();
    private final UserDAO xmlUserDAO = new XMLUserDAO();

    private DAOFactory() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DAOFactory getInstance() {
        return instance;
    }

    /**
     * Gets xml print edition dao.
     *
     * @return the xml print edition dao
     */
    public EditionDAO getXmlPrintEditionDAO() {
        return xmlPrintEditionDAO;
    }

    /**
     * Gets xml user dao.
     *
     * @return the xml user dao
     */
    public UserDAO getXmlUserDAO() {
        return xmlUserDAO;
    }

}
