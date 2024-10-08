package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.board.entities.BoardData;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;

import java.util.List;

//데이터 클래스
//이 정보를 바탕으로 기본적인 테이블이 자동 생성된다.

@Data
@Entity //관리하는 데이터로 인식함
//@Table(name = "CH_MEMBER")
//@Table(indexes = {@Index(name = "idx_created_at_desc"/*내림차순*/,columnList = "createAt DESC"/*db컬럼x 클래스 속성 이름으로*/),
//            @Index(name = "uq_email_password",columnList = "email, password", unique = true)})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {//기본 클래스 명이 테이블 명이 된다.
    @Id @GeneratedValue() //시퀀스 객체로 자동 증감
    private Long seq;
    @Column(length = 60, nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 40, nullable = false, name = "name")
    private String userName;
    //@Lob
    @Transient
    private String introduction;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_seq")
    private MemberProfile profile;

    @ToString.Exclude //ToString 추가 배제
    @OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true) // 관계의 주인(연관관계 주인)을 설정해줘야 한다.
    //제약조건 CASCADE ON DELETE는 아님
    private List<BoardData> items;

}
