package org.choongang.board.entities;

import org.choongang.member.entites.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity { //자동으로 날짜와 시간 가져옴
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY) //기본적으로 외래키가 엔티티명 기본키 기준으로 만들어진다 - member_seq
    @JoinColumn(name = "mSeq")
    private Member member; //다대일 관계에서 게시글쪽이 Many라 게시글쪽에 ManyToOne 정의

    @Column(nullable = false) //필수로 Notnull 제약조건 (varchar2 기본값 크기는 255자)
    private String subject;

    @Lob
    private String content;

    @ManyToMany
    private List<HashTag> tags;
}
