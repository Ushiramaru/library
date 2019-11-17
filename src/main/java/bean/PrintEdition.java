package bean;

import bean.enums.EditionType;
import bean.enums.ListFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * The type Print edition.
 */
@XmlType(name = "printEdition")
public class PrintEdition extends Edition {

    private ListFormat listFormat;
    private int listCount;
    private int publicationYear;

    /**
     * Instantiates a new Print edition.
     */
    public PrintEdition() {
        setEditionType(EditionType.PRINT_EDITION);
    }

    /**
     * Instantiates a new Print edition.
     *
     * @param editionType     the edition type
     * @param id              the id
     * @param title           the title
     * @param listFormat      the list format
     * @param listCount       the list count
     * @param publicationYear the publication year
     */
    public PrintEdition(EditionType editionType, long id, String title, ListFormat listFormat, int listCount, int publicationYear) {
        super(editionType, id, title);
        this.listFormat = listFormat;
        this.listCount = listCount;
        this.publicationYear = publicationYear;
    }

    /**
     * Gets list format.
     *
     * @return the list format
     */
    public ListFormat getListFormat() {
        return listFormat;
    }

    /**
     * Sets list format.
     *
     * @param listFormat the list format
     */
    @XmlElement(name = "listFormat")
    public void setListFormat(ListFormat listFormat) {
        this.listFormat = listFormat;
    }

    /**
     * Gets list count.
     *
     * @return the list count
     */
    public int getListCount() {
        return listCount;
    }

    /**
     * Sets list count.
     *
     * @param listCount the list count
     */
    @XmlElement(name = "listCount")
    public void setListCount(int listCount) {
        this.listCount = listCount;
    }

    /**
     * Gets publication year.
     *
     * @return the publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets publication year.
     *
     * @param publicationYear the publication year
     */
    @XmlElement(name = "publicationYear")
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrintEdition that = (PrintEdition) o;
        return listCount == that.listCount &&
                listFormat == that.listFormat &&
                publicationYear == that.publicationYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), listFormat, listCount, publicationYear);
    }

    @Override
    public String toString() {
        return "PrintEdition{" +
                "listFormat=" + listFormat +
                ", listCount=" + listCount +
                ", publicationYear=" + publicationYear +
                "} " + super.toString();
    }

}
