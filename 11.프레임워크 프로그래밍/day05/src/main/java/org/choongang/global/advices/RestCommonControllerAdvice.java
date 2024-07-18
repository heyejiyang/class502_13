package org.choongang.global.advices;

import org.choongang.global.exceptions.CommonException;
import org.choongang.global.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

// 모든 컨트롤러에서 발생하는 예외를 중앙에서 처리하고, 일관된 형태의 JSON 응답을 반환할 수 있다.
@RestControllerAdvice("org.choongang")
public class RestCommonControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData> errorHandler(Exception e) { //모든 예외를 잡아서 처리

        Object message = e.getMessage(); //예외메시지 가져와서 저장

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 기본 상태 코드 500
        if (e instanceof CommonException commonException) { //내가 정의한 예외 타입인지
            status = commonException.getStatus();

            Map<String, List<String>> errorMessages = commonException.getErrorMessages();
            if (errorMessages != null) message = errorMessages;
        }

        JSONData data = new JSONData(); //응답 데이터 구성
        data.setSuccess(false); //요청 실패
        data.setMessage(message); //예외 메시지 또는 맵 설정
        data.setStatus(status); //필드에 상태코드 설정

        e.printStackTrace();

        return ResponseEntity.status(status).body(data); //반환된 응답은 HTTP 응답으로 변환되어 클라이언트에게 전달
    }
}