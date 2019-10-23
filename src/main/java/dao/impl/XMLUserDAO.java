package dao.impl;

import bean.User;
import dao.UserDAO;
import dao.UsersList;
import dao.exception.DAOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class XMLUserDAO implements UserDAO {

    private final static String FILE_PATH = "/users.xml";
    private String FULL_FILE_PATH;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;

    private UsersList users;

    public XMLUserDAO() {
        try {
            FULL_FILE_PATH = String.valueOf(Paths.get(XMLUserDAO.class.getResource(FILE_PATH).toURI()).toAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(UsersList.class, User.class);
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
            users = (UsersList) unmarshaller.unmarshal(new File(FULL_FILE_PATH));
        } catch (JAXBException e) {
            users = new UsersList();
            users.setUsers(new ArrayList<>());
        }
    }

    private void write()  {
        try {
            marshaller.marshal(users, new File(FULL_FILE_PATH));
        } catch (JAXBException ignored) {

        }
    }

    @Override
    public User signIn(String login, String password) throws DAOException {
        for (User user : users.getUsers()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new DAOException("Incorrect login or password");
    }

    @Override
    public void registration(User user) throws DAOException {
        for (User u : users.getUsers()) {
            if (u.getLogin().equals(user.getLogin())) {
                throw new DAOException("This login already exist");
            }
        }
        users.addUser(user);
        write();
    }

}
