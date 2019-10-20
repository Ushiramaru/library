package bean;

import java.util.Objects;

public abstract class Edition {

    private long id;
    private String title;

    public Edition() {
    }

    public Edition(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edition)) return false;
        Edition edition = (Edition) o;
        return id == edition.id &&
                title.equals(edition.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

}
