package org.choongang.member.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

//데이터 클래스
//이 정보를 바탕으로 기본적인 테이블이 자동 생성된다.

@Data
@Entity //관리하는 데이터로 인식함

public class Member {//기본 클래스 명이 테이블 명이 된다.
    @Id //기본키 지정
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
