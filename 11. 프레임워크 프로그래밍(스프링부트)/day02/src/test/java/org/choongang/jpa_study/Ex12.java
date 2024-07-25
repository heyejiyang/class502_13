package org.choongang.jpa_study;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.QBoardData;
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
@Transactional
public class Ex12 {

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
        List<BoardData> items = boardDataRepository.findAll();

        for(BoardData item: items){
            Member member = item.getMember();
            String email = member.getEmail();
            String userName = member.getUserName();
            System.out.printf("email:%s, userName:%s\n",email,userName);
                    //실제 데이터를 실행했을때 2차 쿼리 실행됨
        }
    }
    @Test
    void test2(){
        List<BoardData> items = boardDataRepository.getAllList();
    }

    @Test
    void test3(){
        List<BoardData> items = boardDataRepository.findBySubjectContaining("제목");
    }

    @Test
    void test4(){

        QBoardData boardData = QBoardData.boardData;
        //싱글톤 형태로 정적인 객체 만들어져있음 - 단점) 처음 로딩될때 너무 많은 객체를 로딩하면 느려진다.

       // JPAQueryFactory factory = new JPAQueryFactory(em);
        // 전용 클래스로 쿼리빌딩 할 수 있음 - Querydsl이 자동으로 만든 Q클래스로 쿼리 빌딩
        JPAQuery<BoardData> query = queryFactory
                .selectFrom(boardData)
                .leftJoin(boardData.member) // boardData.member를 처음부터 조인
                .fetchJoin();

        List<BoardData> items = query.fetch(); //목록조회: fetch()
       // items.forEach(System.out::println);

    }

    @Test
    void test5(){
        QBoardData boardData = QBoardData.boardData;
        //낱개 조회 할때는 해당 데이터의 자료형으로 정의하면 된다.
        //두개 이상일 경우 자료형 -> tuple
//        JPAQuery<String> query = queryFactory.select(boardData.subject);
        JPAQuery<Tuple> query = queryFactory.select(boardData.subject,boardData.content).from(boardData); //낱개 데이터 조회 영속상태와 관계 없음
        List<Tuple> items = query.fetch();
        for(Tuple item:items){
            String subject = item.get(boardData.subject);
            String content = item.get(boardData.content);
            System.out.printf("subject=%s, content=%s\n",subject,content);
        }
    }

    @Test
    void test6(){
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Long> query = queryFactory.select(boardData.seq.sum())
                .from(boardData);
    }
}
