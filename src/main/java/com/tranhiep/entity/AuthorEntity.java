package com.tranhiep.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(
        name = "author",
        indexes = {
                @Index(name = "index_author_id", columnList = "author_id")
        }
)
@NamedQueries(
        @NamedQuery(
                name = "author.getAllAuthorOfBookId",
                query = "from AuthorEntity as a join fetch a.books as b where b.id =:bookId")
)
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true)
    @Column(name = "author_id")
    private Integer id;

    @Expose(serialize = true)
    private String name;



    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH
            })
    @Expose(serialize = false)
    private Collection<BookEntity> books = new ArrayList<>();

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

    public Collection<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Collection<BookEntity> books) {
        this.books = books;
    }

    public void addBook(BookEntity bookEntity){
        books.add(bookEntity);
        bookEntity.getAuthors().add(this);
    }

    public void removeBook(BookEntity bookEntity){
        books.remove(bookEntity);
        bookEntity.getAuthors().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
