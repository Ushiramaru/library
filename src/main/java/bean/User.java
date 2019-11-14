package bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * The type User.
 */
@XmlType(name = "user")
public class User {

    private String login;
    private String password;
    private int age;

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param login    the login
     * @param password the password
     * @param age      the age
     */
    public User(String login, String password, int age) {
        this.login = login;
        this.password = password;
        this.age = age;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    @XmlElement(name = "login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    @XmlAttribute(name = "age")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

}
