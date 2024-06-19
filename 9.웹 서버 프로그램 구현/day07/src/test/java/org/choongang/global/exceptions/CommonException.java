package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException { //유연한 예외 처리를 이해 RuntimeException 상속

    private int status; //응답 코드

    public CommonException(String message){
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 코드 에러 상수형태로
    }

    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
