package dao.factory;

import dao.EditionDAO;
import dao.UserDAO;
import dao.impl.*;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final EditionDAO xmlPrintEditionDAO = new XMLEditionDAO();
    private final UserDAO xmlUserDAO = new XMLUserDAO();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public EditionDAO getXmlPrintEditionDAO() {
        return xmlPrintEditionDAO;
    }

    public UserDAO getXmlUserDAO() {
        return xmlUserDAO;
    }

}
