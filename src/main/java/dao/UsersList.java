package dao;

import bean.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

@XmlRootElement(name = "users")
@XmlSeeAlso(User.class)
public final class UsersList extends ArrayList<User>{

    @XmlElement(name = "user")
    public ArrayList<User> getUsers() {
        return this;
    }

}
