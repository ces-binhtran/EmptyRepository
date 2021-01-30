package com.ces.task3.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "book",
        indexes = {
                @Index(name = "index_book_id", columnList = "", unique = true),
                @Index(name = "index_book_name", columnList = "name")
        }
)
@NamedQueries({
        @NamedQuery(name = "book.getAllByType", query = "select b from BookEntity b where b.type.id = :typeId"),
        @NamedQuery(name = "book.getAllByName", query = "select b from BookEntity b where b.type.name like :query")
})
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    private String name;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE, CascadeType.DETACH,
                    CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "type_id")
    private TypeEntity type;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "books",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    private Set<AuthorEntity> authors = new HashSet<>();

    public void copyValue(BookEntity copyObject){
        this.name = copyObject.getName();
        this.id = copyObject.getId();
    }

    public void addAuthor(AuthorEntity authorEntity){
        this.authors.add(authorEntity);
        authorEntity.getBooks().add(this);
    }

    public void removeAuthor(AuthorEntity authorEntity){
        this.authors.remove(authorEntity);
        authorEntity.getBooks().remove(this);
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
