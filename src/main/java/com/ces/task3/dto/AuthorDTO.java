package com.ces.task3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @NotBlank(message = "Name of Author can not blank")
    private String name;

    @JsonIgnore
    private Collection<@Valid BookDTO> books;
}
