package org.choongang.member.entities;
import jakarta.persistence.*;
import lombok.Data;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

//데이터 클래스
//이 정보를 바탕으로 기본적인 테이블이 자동 생성된다.

@Data
@Entity //관리하는 데이터로 인식함
//@Table(name = "CH_MEMBER")
//@Table(indexes = {@Index(name = "idx_created_at_desc"/*내림차순*/,columnList = "createAt DESC"/*db컬럼x 클래스 속성 이름으로*/),
//            @Index(name = "uq_email_password",columnList = "email, password", unique = true)})
public class Member {//기본 클래스 명이 테이블 명이 된다.
    @Id @GeneratedValue() //시퀀스 객체로 자동 증감
    private Long seq;
    private String email;
    private String password;
    private String userName;

    //@Lob
    @Transient
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

}
