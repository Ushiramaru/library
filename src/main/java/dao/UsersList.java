package dao;

import bean.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

/**
 * The type Users list.
 */
@XmlRootElement(name = "users")
@XmlSeeAlso(User.class)
public final class UsersList extends ArrayList<User>{

    /**
     * Gets users.
     *
     * @return the users
     */
    @XmlElement(name = "user")
    public ArrayList<User> getUsers() {
        return this;
    }

}
