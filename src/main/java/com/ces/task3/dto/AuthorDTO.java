package com.ces.task3.dto;

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
public class AuthorDTO {

    private Integer id;

    @NotBlank @Size
    private String name;

    private Collection<@Valid BookDTO> books;
}
