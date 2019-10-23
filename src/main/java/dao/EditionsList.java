package dao;

import bean.Edition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "editions")
public final class EditionsList {

    private ArrayList<Edition> editions = new ArrayList<>();

    public ArrayList<Edition> getEditions() {
        return editions;
    }

    @XmlElement(name = "edition")
    public void setEditions(ArrayList<Edition> editions) {
        this.editions = editions;
    }

    public boolean addEdition(Edition edition) {
        return editions.add(edition);
    }

    public boolean deleteEdition(Edition edition) {
        return editions.remove(edition);
    }

}