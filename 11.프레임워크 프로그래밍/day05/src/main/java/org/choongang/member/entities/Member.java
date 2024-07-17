package org.choongang.member.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table("CH_MEMBER") //클래스명과 테이블명을 다르게 써야할때 이 애노테이션을 사용하면 Member -> CH_MEMBER 테이블에 매칭된다.
public class Member {
    @Id
//    @Column("ID")//컬럼명 ID로 매칭
    private Long seq;
    private String email;

    @JsonIgnore
    private String password;
    private String userName;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
