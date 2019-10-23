package dao.impl;

import bean.*;
import bean.enums.Genre;
import bean.enums.ListFormat;
import dao.EditionDAO;
import dao.EditionsList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class XMLEditionDAO implements EditionDAO {

    private final static String FILE_PATH = "/editions.xml";
    private String FULL_FILE_PATH;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;

    private EditionsList editions;

    public static void main(String[] args) {
        XMLEditionDAO xmlEditionDAO = new XMLEditionDAO();
        xmlEditionDAO.editions.addEdition(new Book(1, "title", ListFormat.A1, 10, new Date(), Genre.DETECTIVE));
        xmlEditionDAO.editions.addEdition(new Book(2, "title1", ListFormat.A4, 20, new Date(), Genre.FANTASY));
        xmlEditionDAO.write();
    }

    public XMLEditionDAO() {
        try {
            FULL_FILE_PATH = String.valueOf(Paths.get(XMLUserDAO.class.getResource(FILE_PATH).toURI()).toAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(EditionsList.class, Edition.class, PrintEdition.class,
                    Book.class, Encyclopedia.class, Newspaper.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            read();
        } catch (URISyntaxException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void read() {
        try {
            editions = (EditionsList) unmarshaller.unmarshal(new File(FULL_FILE_PATH));
        } catch (JAXBException e) {
            editions = new EditionsList();
            editions.setEditions(new ArrayList<Edition>());
        }
    }

    private void write() {
        try {
            marshaller.marshal(editions, new File(FULL_FILE_PATH));
        } catch (JAXBException ignored) {

        }
    }

    @Override
    public void addEdition(Edition edition) {

    }

    @Override
    public void deleteEdition(long id) {

    }

    @Override
    public void delete(Edition edition) {

    }

}
