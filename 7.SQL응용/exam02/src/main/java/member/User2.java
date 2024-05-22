package member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDateTime;

@Builder @ToString
//builder 패턴은 기본 생성자가 private이다. 기본 생성자를 꼭 써야하는경우
//편법으로... @NoArgsConstructor, @AllArgsConstructor 사용
@NoArgsConstructor @AllArgsConstructor
public class User2 {
    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}
