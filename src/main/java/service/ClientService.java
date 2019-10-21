package service;

import bean.User;
import dao.exception.DAOException;
import service.exeption.ServiceException;

public interface ClientService {

    void signIn(String login, String password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;

}
