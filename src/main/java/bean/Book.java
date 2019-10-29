package bean;

import bean.enums.Genre;
import bean.enums.ListFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "book")
public class Book extends PrintEdition {

    private Genre genre;

    public Book() {

    }

    public Book(long id, String title, ListFormat listFormat, int listCount, int publicationDate, Genre genre) {
        super(id, title, listFormat, listCount, publicationDate);
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @XmlElement(name = "genre")
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "genre=" + genre +
                "} " + super.toString();
    }

}
