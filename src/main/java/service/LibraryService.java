package service;

import bean.Edition;
import service.exeption.ServiceException;

public interface LibraryService {

    void addNewEdition(Edition edition) throws ServiceException;

    void editedEdition(long id, Edition edition) throws ServiceException;

    void deleteEdition(long id) throws ServiceException;

    String showEdition() throws ServiceException;

    String sortEdition(String comparatorName) throws ServiceException;

}
