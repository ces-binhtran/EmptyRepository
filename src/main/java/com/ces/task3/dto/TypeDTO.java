package com.ces.task3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TypeDTO {

    private Integer id;

    @NotNull
    private String name;

}
