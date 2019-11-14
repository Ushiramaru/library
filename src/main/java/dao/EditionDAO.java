package dao;

import bean.Edition;
import dao.exception.DAOException;

import java.util.ArrayList;

/**
 * The interface Edition dao.
 */
public interface EditionDAO {

    /**
     * Add edition.
     *
     * @param edition the edition
     * @throws DAOException the dao exception
     */
    void addEdition(Edition edition) throws DAOException;

    /**
     * Edited edition.
     *
     * @param id      the id
     * @param edition the edition
     * @throws DAOException the dao exception
     */
    void editedEdition(long id, Edition edition) throws DAOException;

    /**
     * Delete edition.
     *
     * @param id the id
     * @throws DAOException the dao exception
     */
    void deleteEdition(long id) throws DAOException;

    /**
     * Show edition array list.
     *
     * @return the array list
     * @throws DAOException the dao exception
     */
    ArrayList<Edition> showEdition() throws DAOException;

}
