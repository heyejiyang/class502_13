package org.choongang.jpa_study;

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
@ActiveProfiles("test")
@Transactional //관계가 있는 데이터 조회에는 one엔티티가 영속상태를 유지하기 위해 Transactional을 많이씀
public class Ex09 {

    @Autowired
    private MemberRepository memberRepository; //회원
    @Autowired
    private BoardDataRepository boardDataRepository;

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
        BoardData item = boardDataRepository.findById(1L).orElse(null); //조회
        System.out.println(item);

        Member member = item.getMember(); //게시글을 작성한 회원
        System.out.println(member); //member쪽 항목을 사용해야 쿼리가 실행된다.
    }

    @Test
    void test2(){
        Member member = memberRepository.findById(1L).orElse(null);
        List<BoardData> items = member.getItems();
        items.forEach(System.out::println);
    }

}
