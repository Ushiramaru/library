package dao;

import bean.Edition;
import dao.exception.DAOException;

public interface EditionDAO {

    void addEdition(Edition edition) throws DAOException;

    void deleteEdition(long id) throws DAOException;

    void delete(Edition edition) throws DAOException;

}
