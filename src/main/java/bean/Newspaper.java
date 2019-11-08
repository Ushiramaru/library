package bean;

import bean.enums.EditionType;
import bean.enums.ListFormat;
import bean.enums.NewspaperType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "newspaper")
public class Newspaper extends PrintEdition {

    private NewspaperType newspaperType;

    public Newspaper() {

    }

    public Newspaper(EditionType editionType, long id, String title, ListFormat listFormat, int listCount, int publicationYear, NewspaperType newspaperType) {
        super(editionType, id, title, listFormat, listCount, publicationYear);
        this.newspaperType = newspaperType;
    }

    public NewspaperType getNewspaperType() {
        return newspaperType;
    }

    @XmlElement(name = "newspaperType")
    public void setNewspaperType(NewspaperType newspaperType) {
        this.newspaperType = newspaperType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return newspaperType == newspaper.newspaperType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), newspaperType);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "newspaperType=" + newspaperType +
                "} " + super.toString();
    }

}
