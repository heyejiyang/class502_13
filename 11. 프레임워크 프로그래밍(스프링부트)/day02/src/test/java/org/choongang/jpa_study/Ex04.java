package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex04 {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test1() throws Exception {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setUserName("사용자01");

        em.persist(member);
        em.flush();

        em.clear(); //영속성을 지워야 다시 조회 할 수 있기 때문에 영속성 초기화 시킴

        member = em.find(Member.class,member.getSeq());
        System.out.printf("createdAt: %s, modifiedAt: %s\n", member.getCreatedAt(), member.getModifiedAt());

        //수정
        Thread.sleep(5000); //5초 뒤 수정 후 실제 시간차이 나는지 체크
        member.setUserName("장사용자");
        member.setCreatedAt(LocalDateTime.now());
        em.flush();
        em.clear(); //다시 쿼리 실행 위해

        member = em.find(Member.class,member.getSeq());
        System.out.printf("createdAt: %s, modifiedAt: %s\n", member.getCreatedAt(), member.getModifiedAt());
    }
}
