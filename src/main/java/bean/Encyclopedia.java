package bean;

import bean.enums.EditionType;
import bean.enums.EncyclopediaType;
import bean.enums.ListFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "encyclopedia")
public class Encyclopedia extends PrintEdition {

    private EncyclopediaType encyclopediaType;

    public Encyclopedia() {

    }

    public Encyclopedia(EditionType editionType, long id, String title, ListFormat listFormat, int listCount, int publicationYear, EncyclopediaType encyclopediaType) {
        super(editionType, id, title, listFormat, listCount, publicationYear);
        this.encyclopediaType = encyclopediaType;
    }

    public EncyclopediaType getEncyclopediaType() {
        return encyclopediaType;
    }

    @XmlElement(name = "encyclopediaType")
    public void setEncyclopediaType(EncyclopediaType encyclopediaType) {
        this.encyclopediaType = encyclopediaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Encyclopedia that = (Encyclopedia) o;
        return encyclopediaType == that.encyclopediaType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), encyclopediaType);
    }

    @Override
    public String toString() {
        return "Encyclopedia{" +
                "encyclopediaType=" + encyclopediaType +
                "} " + super.toString();
    }

}
