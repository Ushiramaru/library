package dao.factory;

import dao.EditionDAO;
import dao.UserDAO;
import dao.XMLValidatorByXSD;
import dao.impl.*;

/**
 * The type Dao factory.
 */
public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final EditionDAO xmlPrintEditionDAO =
//            new SQLEditionDAO("library", "root", "");
            new XMLEditionDAO(
            new XMLValidatorByXSD("D:\\library\\src\\main\\resources\\a.xsd"),
            "D:\\library\\src\\main\\resources\\editions.xml");
    private final UserDAO xmlUserDAO = new XMLUserDAO(
            new XMLValidatorByXSD("D:\\library\\src\\main\\resources\\s.xsd"),
            "D:\\library\\src\\main\\resources\\users.xml");

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