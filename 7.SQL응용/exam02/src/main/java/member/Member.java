package member;

import lombok.*;

import java.time.LocalDateTime;

//@Getter @Setter @ToString @EqualsAndHashCode
@Data
@AllArgsConstructor //모든 변수가 생성자 매개변수로 들어감
@NoArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)//기본 생성자 , 접근제어범위 private으로 바꿈
@RequiredArgsConstructor // 필수 멤버변수를 생성자 매개변수로 추가 (모든 변수 x)
public class Member {
    @NonNull
    private String userId;
    @NonNull
    private String userNm;
    private String email;
    @ToString.Exclude //toString메서드에 이 항목은 배제됨
    private LocalDateTime regDt;
}
