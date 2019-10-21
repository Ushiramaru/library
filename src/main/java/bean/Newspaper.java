package bean;

import bean.enums.ListFormat;
import bean.enums.NewspaperType;

import java.util.Date;
import java.util.Objects;

public class Newspaper extends PrintEdition {

    private NewspaperType newspaperType;

    public Newspaper() {

    }

    public Newspaper(long id, String title, ListFormat listFormat, int listCount, Date publicationDate, NewspaperType newspaperType) {
        super(id, title, listFormat, listCount, publicationDate);
        this.newspaperType = newspaperType;
    }

    public NewspaperType getNewspaperType() {
        return newspaperType;
    }

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
