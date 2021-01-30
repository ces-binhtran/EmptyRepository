package com.ces.task3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Integer id;

    @NotBlank(message = "Must not be blank")
    @Size(min = 5, max = 30, message = "Size must be between 5 and 30")
    private String name;

    @Valid
    private TypeDTO type;

    @JsonIgnore
    private Set<@Valid AuthorDTO> authors = new HashSet<>();

    public void copyValue(BookDTO book){
        this.id = book.getId();
        this.name = book.getName();
        this.type = book.getType();
        this.authors = book.getAuthors();
    }
}
