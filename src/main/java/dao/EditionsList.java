package dao;

import bean.Edition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Comparator;

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

    public void deleteEdition(long id) {
        editions.removeIf(edition -> edition.getId() == id);
    }

    public void sort(Comparator<Edition> comparator) {
        editions.sort(comparator);
    }

}
