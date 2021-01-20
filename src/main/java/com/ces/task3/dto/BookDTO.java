package com.ces.task3.dto;

import com.ces.task3.entity.AuthorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Integer id;

    @NotBlank @Size(min = 5, max = 30)
    private String name;

    @Valid
    private TypeDTO type;

    private Collection<@Valid AuthorEntity> authors;
}
