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
        DAOFactory daoFactory = DAOFactory.getInstance();
        EditionDAO editionDAO = daoFactory.getXmlEditionDAO();
        try {
            editionDAO.addEdition(edition);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEditedEdition(Edition edition) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EditionDAO editionDAO = daoFactory.getXmlEditionDAO();
        try {
            editionDAO.deleteEdition(edition.getId());
            editionDAO.addEdition(edition);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void deleteEdition(long id) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EditionDAO editionDAO = daoFactory.getXmlEditionDAO();
        try {
            editionDAO.deleteEdition(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Edition edition) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EditionDAO editionDAO = daoFactory.getXmlEditionDAO();
        try {
            editionDAO.delete(edition);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
