package dao.impl;

import bean.*;
import dao.EditionDAO;
import dao.EditionsList;
import dao.XMLValidator;
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

    private String xmlFileName;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;
    private XMLValidator xmlValidator;

    /**
     * Instantiates a new Xml edition dao.
     *
     * @param xmlValidator the xml validator
     * @param xmlFileName  the xml file name
     */
    public XMLEditionDAO(XMLValidator xmlValidator, String xmlFileName) {
        this.xmlValidator = xmlValidator;
        this.xmlFileName = xmlFileName;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EditionsList.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private EditionsList read() throws DAOException {
        if (xmlValidator.isValid(xmlFileName)) {
            try {
                return (EditionsList) unmarshaller.unmarshal(new File(xmlFileName));
            } catch (JAXBException e) {
                throw new DAOException("Invalid xml");
            }
        }
        throw new DAOException("Invalid xml");
    }

    private void write(EditionsList editions) {
        try {
            marshaller.marshal(editions, new File(xmlFileName));
        } catch (JAXBException ignored) {

        }
    }

    @Override
    public void addEdition(Edition edition) throws DAOException {
        EditionsList editions = read();
        for (Edition edition1 : editions) {
            if (edition.getId() == edition1.getId()) {
                throw new DAOException("Edition with " + edition.getId() + " id exist");
            }
        }
        editions.add(edition);
        write(editions);
    }

    @Override
    public void editedEdition(long id, Edition editedEdition) throws DAOException {
        EditionsList editions = read();
        for (Edition currEdition : editions) {
            if (editedEdition.getId() == currEdition.getId() && currEdition.getId() != id) {
                throw new DAOException("Edition with " + editedEdition.getId() + " id exist");
            }
        }
        editions.removeIf(edition -> edition.getId() == id);
        editions.add(editedEdition);
        write(editions);
    }

    @Override
    public void deleteEdition(long id) throws DAOException {
        EditionsList editions = read();
        editions.removeIf(edition -> edition.getId() == id);
        write(editions);
    }

    @Override
    public ArrayList<Edition> showEdition() throws DAOException {
        return read();
    }

}
