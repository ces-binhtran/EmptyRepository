package com.tranhiep.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(
        name = "book",
        indexes = {
                @Index(name = "index_book_id", columnList = "book_id")
        }
)

@NamedQueries(
        @NamedQuery(name = "book.getAllByAuthorId", query = "from BookEntity as b join fetch b.authors as a where a.id =:authorId")
)
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    @Expose(serialize = true)
    private Integer id;


    @Column(nullable = false, length = 50)
    @Expose(serialize = true)
    private String name;

    @Column(length = 10)
    @Expose(serialize = true)
    private String type;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH
            })
    @JoinTable(
            name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    @Expose(serialize = true)
    private Collection<AuthorEntity> authors = new ArrayList<>();

    public BookEntity(){}
    public BookEntity(String name, String type) {
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<AuthorEntity> authors) {
        this.authors = authors;
    }

    public void setValue(String name, String type){
        this.name = name;
        this.type = type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
