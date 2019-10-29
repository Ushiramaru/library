package dao;

import bean.Edition;
import dao.exception.DAOException;

import java.util.ArrayList;

public interface EditionDAO {

    void addEdition(Edition edition) throws DAOException;

    void editedEdition(long id, Edition edition) throws DAOException;

    void deleteEdition(long id) throws DAOException;

    ArrayList<Edition> showEdition() throws DAOException;

}
