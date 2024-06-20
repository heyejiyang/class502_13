package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class BadRequestException extends CommonException{

    //기본 문구
    public BadRequestException() {
        this("잘못된 요청입니다.");
    }

    public BadRequestException(String mesage) {
        //응답코드 400으로 고정
        super(mesage, HttpServletResponse.SC_BAD_REQUEST); //부모 생성자에 응답코드 전달
    }
}
