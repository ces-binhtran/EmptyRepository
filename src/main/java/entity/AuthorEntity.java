package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private List<BookEntity> books = new ArrayList<BookEntity>();

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return id.equals(that.id) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void addBook(BookEntity bookEntity) {
        boolean isDuplicate = false;
        books.add(bookEntity);
        for(AuthorEntity authorEntity : bookEntity.getAuthors()) {
            if(authorEntity.getId() == this.getId()) {
                isDuplicate = true;
            }
        }
        if (isDuplicate) {
            bookEntity.getAuthors().add(this);
        }
    }

    public void removeBook(BookEntity bookEntity) {
        books.remove(bookEntity);
        bookEntity.getAuthors().remove(this);
    }
}
