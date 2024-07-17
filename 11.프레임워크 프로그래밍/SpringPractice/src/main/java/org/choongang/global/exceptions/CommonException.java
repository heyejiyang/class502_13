package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

//공통 예외처리
public class CommonException extends RuntimeException{

    private HttpStatus status; //스프링쪽에서 제공하는 응답코드 enum 상수 클래스

    //응답코드 고정
    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);//500대 응답코드
    }

    public CommonException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    //상수 조회 클래스
    public HttpStatus getStatus() {
        return status;
    }
}
