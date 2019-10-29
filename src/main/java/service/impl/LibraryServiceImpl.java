package service.impl;

import bean.Edition;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.EditionDAO;
import service.EditionComparatorProvider;
import service.LibraryService;
import service.exeption.ServiceException;

import java.util.ArrayList;

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

    @Override
    public String showEdition() throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        EditionDAO dao = factory.getXmlEditionDAO();

        String response = "";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<Edition> editions = dao.showEdition();
            for (Edition edition : editions) {
                stringBuilder.append(edition.toString());
                stringBuilder.append('\n');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            response = stringBuilder.toString();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return response;
    }

    @Override
    public String sortEdition(String comparatorName) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        EditionDAO dao = factory.getXmlEditionDAO();

        String response = "";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<Edition> editions = dao.showEdition();
            EditionComparatorProvider comparatorProvider = EditionComparatorProvider.getInstance();
            editions.sort(comparatorProvider.getComparator(comparatorName.toUpperCase()));
            for (Edition edition : editions) {
                stringBuilder.append(edition.toString());
                stringBuilder.append('\n');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            response = stringBuilder.toString();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return response;
    }

}
