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

public class XMLEditionDAO implements EditionDAO {

    private String FULL_FILE_PATH;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;

    private EditionsList editions;

    public XMLEditionDAO() {
        try {
            FULL_FILE_PATH = "D:\\library\\out\\artifacts\\library_jar\\editions.xml";
            JAXBContext jaxbContext = JAXBContext.newInstance(EditionsList.class, Edition.class, PrintEdition.class,
                    Book.class, Encyclopedia.class, Newspaper.class);
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
            editions.setEditions(new ArrayList<>());
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
        for (Edition edition1 : editions.getEditions()) {
            if (edition.getId() == edition1.getId()) {
                throw new DAOException("Edition with " + edition.getId() + " id exist");
            }
        }
        editions.addEdition(edition);
        write();
    }

    @Override
    public void editedEdition(long id, Edition edition) throws DAOException {
        for (Edition edition1 : editions.getEditions()) {
            if (edition.getId() == edition1.getId() && edition1.getId() != id) {
                throw new DAOException("Edition with " + edition.getId() + " id exist");
            }
        }
        editions.deleteEdition(id);
        editions.addEdition(edition);
        write();
    }

    @Override
    public void deleteEdition(long id) {
        editions.deleteEdition(id);
        write();
    }

    @Override
    public ArrayList<Edition> showEdition() throws DAOException {
        return editions.getEditions();
    }

}
