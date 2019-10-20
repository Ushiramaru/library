package service;

import bean.User;

public interface ClientService {

    void singIn(String login, String password);
    void singOut(String login);
    void registration(User user);

}
