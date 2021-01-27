package com.ces.task3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TypeDTO {

    @Min(value = 1, message = "Please chose Type for Book")
    private Integer id;

    @NotBlank(message = "Name of book can not bank")
    private String name;

}
