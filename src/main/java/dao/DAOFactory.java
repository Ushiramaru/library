package dao;

import dao.impl.XMLEditionDAO;
import dao.impl.XMLUserDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final EditionDAO xmlBookImpl = new XMLEditionDAO();
    private final UserDAO xmlUserImpl = new XMLUserDAO();

    private DAOFactory(){
    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public EditionDAO getXmlBookImpl() {
        return xmlBookImpl;
    }

    public UserDAO getXmlUserImpl() {
        return xmlUserImpl;
    }

}
