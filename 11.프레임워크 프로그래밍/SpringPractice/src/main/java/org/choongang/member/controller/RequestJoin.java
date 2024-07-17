package org.choongang.member.controller;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank //필수항목 검증 애노테이션
    @Email //이메일 형식 검증 애노테이션
    private String email;
    @NotBlank
    @Size(min = 8) //비밀번호 자리수 검증 애노테이션
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String userName;
    @AssertTrue
    private boolean agree;
}
