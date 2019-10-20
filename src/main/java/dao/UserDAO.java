package dao;

import bean.User;

public interface UserDAO {

    void signIn(String login, String password);
    void registration(User user);

}
