package org.choongang.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank //필수항목 검증 애노테이션
    @Email //이메일 형식검증
    private String email;

    @NotBlank
    @Size(min = 8, max = 20) //8자리 이상
    private String password;

    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String userName;

    @AssertTrue
    private boolean agree;
}



//@Data
//public class RequestJoin {
//    private String email;
//    private String password;
//    private String confirmPassword;
//    private String userName;
////    private String[] hobby;
////    private Set<String> hobby;
//    private String hobby;
//    private boolean agree;
//
//    private Address addr;
//}
