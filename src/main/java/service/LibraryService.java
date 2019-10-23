package service;

import bean.Edition;
import service.exeption.ServiceException;

public interface LibraryService {

    void addNewEdition(Edition edition) throws ServiceException;

    void addEditedEdition(Edition edition) throws ServiceException;

    void deleteEdition(long id) throws ServiceException;

}
