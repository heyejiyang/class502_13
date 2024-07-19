package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class BadRequestException extends CommonException{
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST); //400대 응답코드 고정
    }
    public BadRequestException(Map<String, List<String>> errorMessages){
        super(null, HttpStatus.BAD_REQUEST);
        setErrorMessages(errorMessages);  //커맨드객체 에러 부모 CommonException에 줌
    }
}
