package org.choongang;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor //기본 생성자 생성
@AllArgsConstructor // 밑에 데이터들 초기화 해주는 매개변수가 있는 생성자 생성
public class SocketData {
    //보내는쪽 받는쪽 메시지 형태 구성
    //getter은 문자열로 setter은 다시 자바객체로

    private String from; //보내는쪽
    private String to; //받는쪽
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//날짜형식을 표현할때 사용
    private LocalDateTime regDt;
}
