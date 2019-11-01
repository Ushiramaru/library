package dao;

import bean.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Comparator;

@XmlRootElement(name = "editions")
@XmlSeeAlso({Edition.class, PrintEdition.class, Book.class, Encyclopedia.class, Newspaper.class})
public final class EditionsList extends ArrayList<Edition>{

    @XmlElement(name = "edition")
    public ArrayList<Edition> getEditions() {
        return this;
    }

}
