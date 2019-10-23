package dao;

import bean.User;
import dao.exception.DAOException;

public interface UserDAO {

    User signIn(String login, String password) throws DAOException;

    void registration(User user) throws DAOException;

}