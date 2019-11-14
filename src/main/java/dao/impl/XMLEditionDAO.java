package dao.impl;

import bean.*;
import dao.EditionDAO;
import dao.EditionsList;
import dao.exception.DAOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * The type Xml edition dao.
 */
public class XMLEditionDAO implements EditionDAO {

    private String FULL_FILE_PATH;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;

    private EditionsList editions;

    /**
     * Instantiates a new Xml edition dao.
     */
    public XMLEditionDAO() {
        try {
            FULL_FILE_PATH = "D:\\library\\out\\artifacts\\library_jar\\editions.xml";
            JAXBContext jaxbContext = JAXBContext.newInstance(EditionsList.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            read();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void read() {
        try {
            editions = (EditionsList) unmarshaller.unmarshal(new File(FULL_FILE_PATH));
        } catch (JAXBException e) {
            editions = new EditionsList();
        }
    }

    private void write() {
        try {
            marshaller.marshal(editions, new File(FULL_FILE_PATH));
        } catch (JAXBException ignored) {

        }
    }

    @Override
    public void addEdition(Edition edition) throws DAOException {
        for (Edition edition1 : editions) {
            if (edition.getId() == edition1.getId()) {
                throw new DAOException("Edition with " + edition.getId() + " id exist");
            }
        }
        editions.add(edition);
        write();
    }

    @Override
    public void editedEdition(long id, Edition editedEdition) throws DAOException {
        for (Edition currEdition : editions) {
            if (editedEdition.getId() == currEdition.getId() && currEdition.getId() != id) {
                throw new DAOException("Edition with " + editedEdition.getId() + " id exist");
            }
        }
        editions.removeIf(edition -> edition.getId() == id);
        editions.add(editedEdition);
        write();
    }

    @Override
    public void deleteEdition(long id) {
        editions.removeIf(edition -> edition.getId() == id);
        write();
    }

    @Override
    public ArrayList<Edition> showEdition() throws DAOException {
        return editions;
    }

}
