package bean;

import bean.enums.ListFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.Objects;

@XmlType(name = "printEdition")
public abstract class PrintEdition extends Edition {

    private ListFormat listFormat;
    private int listCount;
    private Date publicationDate;

    public PrintEdition() {

    }

    public PrintEdition(long id, String title, ListFormat listFormat, int listCount, Date publicationDate) {
        super(id, title);
        this.listFormat = listFormat;
        this.listCount = listCount;
        this.publicationDate = publicationDate;
    }

    public ListFormat getListFormat() {
        return listFormat;
    }

    @XmlElement(name = "listFormat")
    public void setListFormat(ListFormat listFormat) {
        this.listFormat = listFormat;
    }

    public int getListCount() {
        return listCount;
    }

    @XmlElement(name = "listCount")
    public void setListCount(int listCount) {
        this.listCount = listCount;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    @XmlElement(name = "publicationDate")
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrintEdition that = (PrintEdition) o;
        return listCount == that.listCount &&
                listFormat == that.listFormat &&
                publicationDate.equals(that.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), listFormat, listCount, publicationDate);
    }

    @Override
    public String toString() {
        return "PrintEdition{" +
                "listFormat=" + listFormat +
                ", listCount=" + listCount +
                ", publicationDate=" + publicationDate +
                "} " + super.toString();
    }

}
