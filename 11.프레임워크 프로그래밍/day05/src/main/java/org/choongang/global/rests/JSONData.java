package org.choongang.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
//Json은 틀을 정해 공통된 형식으로 보내는게 좋음
public class JSONData {
    private HttpStatus status = HttpStatus.OK; //200
    private boolean success = true; //요청의 성공 여부
    private Object message; // 실패이유 메세지
    @NonNull
    private Object data; // 실제 응답 데이터
    // 예외 처리 시에는 사용되지 않지만, 일반적인 성공 응답에서는 실제 데이터가 이 필드에 저장

}
