package org.choongang.member.controllers;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String userName;
    @AssertTrue
    private boolean agree;
}
