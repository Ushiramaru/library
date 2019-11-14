package bean;

import bean.enums.EditionType;
import bean.enums.Genre;
import bean.enums.ListFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * The type Book.
 */
@XmlType(name = "book")
public class Book extends PrintEdition {

    private Genre genre;

    /**
     * Instantiates a new Book.
     */
    public Book() {

    }

    /**
     * Instantiates a new Book.
     *
     * @param editionType     the edition type
     * @param id              the id
     * @param title           the title
     * @param listFormat      the list format
     * @param listCount       the list count
     * @param publicationYear the publication year
     * @param genre           the genre
     */
    public Book(EditionType editionType, long id, String title, ListFormat listFormat, int listCount, int publicationYear, Genre genre) {
        super(editionType, id, title, listFormat, listCount, publicationYear);
        this.genre = genre;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
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