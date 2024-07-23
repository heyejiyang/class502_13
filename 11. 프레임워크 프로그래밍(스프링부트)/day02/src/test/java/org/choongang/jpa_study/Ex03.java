package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class Ex03 {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test1(){
        Member member = new Member();
        //seq 직접 입력하지 않아도 된다
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);

        Member member2 = new Member();
        //seq 직접 입력하지 않아도 된다
        member2.setEmail("user02@test.org");
        member2.setPassword("12341234");
        member2.setUserName("사용자02");
        member2.setCreatedAt(LocalDateTime.now());

        em.persist(member2);
        em.flush();

        em.clear();

        Member _member1 = em.find(Member.class,member.getSeq());//기본키 값 자동으로 만들어짐
        System.out.println(_member1);
        Member _member2 = em.find(Member.class,member2.getSeq());
        System.out.println(_member2);
    }
}
