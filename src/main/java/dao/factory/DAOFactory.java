package dao.factory;

import dao.EditionDAO;
import dao.UserDAO;
import dao.impl.XMLEditionDAO;
import dao.impl.XMLUserDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final EditionDAO xmlEditionDAO = new XMLEditionDAO();
    private final UserDAO xmlUserImpl = new XMLUserDAO();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public EditionDAO getXmlEditionDAO() {
        return xmlEditionDAO;
    }

    public UserDAO getXmlUserImpl() {
        return xmlUserImpl;
    }

}
