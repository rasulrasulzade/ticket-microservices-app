package com.company.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String id ;

    private String username;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Last name cannot be null")
    private String surname;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Birthdate cannot be null")
    private Date birthDate;

}
