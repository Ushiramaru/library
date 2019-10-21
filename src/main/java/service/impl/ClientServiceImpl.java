package service.impl;

import bean.User;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.UserDAO;
import service.ClientService;
import service.exeption.LoginException;
import service.exeption.PasswordException;
import service.exeption.ServiceException;

public class ClientServiceImpl implements ClientService {

    @Override
    public void signIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()) {
            throw new LoginException("Incorrect login");
        }
        if (password == null || password.isEmpty()) {
            throw new PasswordException("Incorrect password");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getXmlUserImpl();
        try {
            userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(String login) throws ServiceException {
        if (login == null || login.isEmpty()) {
            throw new LoginException("Incorrect login");
        }
    }

    @Override
    public void registration(User user) throws ServiceException {
        if (user == null || user.getLogin() == null || user.getPassword() == null) {
            throw new ServiceException("Incorrect user's data");
        }
        if (user.getLogin().length() < 3) {
            throw new LoginException("Login must be at least 3 symbols");
        }
        if (user.getPassword().length() < 8) {
            throw new PasswordException("Password must be at least 8 symbols");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getXmlUserImpl();
        try {
            userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
