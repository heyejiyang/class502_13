package org.choongang.jpa_study;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class Ex13 {

    @Autowired
    private MemberRepository memberRepository; //회원
    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private JPAQueryFactory queryFactory;     //빈으로 등록한 완성된 객체

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init(){
        em.setFlushMode(FlushModeType.AUTO);

        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345612")
                .userName("사용자01")
                .authority(Authority.USER)
                .build();

        memberRepository.saveAndFlush(member);

        //게시글 작성 - member 엔티티를 꼭 추가시켜야함 외래키로 회원 번호가 들어간다
        List<BoardData> items = IntStream.rangeClosed(1,10)
                .mapToObj( i -> BoardData.builder()
                        .subject("제목"+i)
                        .content("내용"+i)
                        .member(member)
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);

        em.clear();//테스트 할때는 영속성 컨텍스트의 모든 엔티티를 비워주는게 좋음
    }

    @Test
    void test1(){
        Member member = memberRepository.findById(1L).orElse(null);
        //회원을 지우면 해당되는 게시글도 제거되도록
        memberRepository.delete(member); //사용자01
        memberRepository.flush();
    }

    @Test
    void test2(){
        Member member = memberRepository.findById(1L).orElse(null);

        List<BoardData> items = member.getItems();
        //0번과 1번객체를 고아상태로 만들기
        items.remove(0);
        items.remove(1); //db에는 존재하지만 객체로는 존재하지 않는 상태
        //items라는 집에서 제거된거고 (참조 끊긴 상태) 아직 영속성 컨텍스트에 남아있음

        memberRepository.flush(); //완전 삭제
    }
}
