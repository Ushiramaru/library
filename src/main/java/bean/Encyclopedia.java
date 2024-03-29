package bean;

import bean.enums.EditionType;
import bean.enums.EncyclopediaType;
import bean.enums.ListFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * The type Encyclopedia.
 */
@XmlType(name = "encyclopedia")
public class Encyclopedia extends PrintEdition {

    private EncyclopediaType encyclopediaType;

    /**
     * Instantiates a new Encyclopedia.
     */
    public Encyclopedia() {

    }

    /**
     * Instantiates a new Encyclopedia.
     *
     * @param editionType      the edition type
     * @param id               the id
     * @param title            the title
     * @param listFormat       the list format
     * @param listCount        the list count
     * @param publicationYear  the publication year
     * @param encyclopediaType the encyclopedia type
     */
    public Encyclopedia(EditionType editionType, long id, String title, ListFormat listFormat, int listCount, int publicationYear, EncyclopediaType encyclopediaType) {
        super(editionType, id, title, listFormat, listCount, publicationYear);
        this.encyclopediaType = encyclopediaType;
    }

    /**
     * Gets encyclopedia type.
     *
     * @return the encyclopedia type
     */
    public EncyclopediaType getEncyclopediaType() {
        return encyclopediaType;
    }

    /**
     * Sets encyclopedia type.
     *
     * @param encyclopediaType the encyclopedia type
     */
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
