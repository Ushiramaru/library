package service.impl;

import bean.Edition;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.EditionDAO;
import service.LibraryService;
import service.exeption.ServiceException;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public void addNewEdition(Edition edition) throws ServiceException {
        if (edition == null) {
            throw new ServiceException("Unknown edition's type");
        }

        DAOFactory factory = DAOFactory.getInstance();
        EditionDAO dao = factory.getXmlEditionDAO();

        try {
            dao.addEdition(edition);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void editedEdition(long id, Edition edition) throws ServiceException {
        if (edition == null) {
            throw new ServiceException("Unknown edition's type");
        }

        DAOFactory factory = DAOFactory.getInstance();
        EditionDAO dao = factory.getXmlEditionDAO();

        try {
            dao.editedEdition(id, edition);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void deleteEdition(long id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        EditionDAO dao = factory.getXmlEditionDAO();

        try {
            dao.deleteEdition(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
