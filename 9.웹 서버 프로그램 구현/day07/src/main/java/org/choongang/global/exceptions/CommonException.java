package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException { //유연한 예외 처리를 이해 RuntimeException 상속

    private int status; //응답 코드

    public CommonException(String message){
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 코드 에러 상수형태로
    }

    public CommonException(String message, int status) { //상속받고있던 BadRequesetException에서 super매개변수로 응답코드 전달해줬기 때문에 status에 해당 코드 들어감
        super(message);
        this.status = status;
    }

    public int getStatus() { //받아온 응답코드 다른곳에서 getStatus 불러서 실행
        return status;
    }
}
