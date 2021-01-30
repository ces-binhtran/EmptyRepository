package com.ces.task3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AdminDTO {

    private Integer id;

    @NotBlank @Size(min = 5, max = 20)
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;


    public boolean sameAccount(AdminDTO admin){
        return email == admin.getEmail() &&
                password == admin.getPassword();
    }


}
