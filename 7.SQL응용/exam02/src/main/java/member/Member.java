package member;

import lombok.*;

import java.time.LocalDateTime;

//@Getter @Setter @ToString @EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    private String userId;
    private String userNm;
    private String email;

    private LocalDateTime regDt;
}
