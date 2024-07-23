package com.choongang.jpa_study;

import com.choongang.member.entites.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02 {

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        for (long i = 1L; i <= 10L; i++) {
            Member member = new Member();
            member.setSeq(i);
            member.setEmail("user" + i + "@test.org");
            member.setPassword("12345678");
            member.setUserName("사용자01" + i);
            member.setCreatedAt(LocalDateTime.now());
            em.persist(member); //영속 상태
        }
        em.flush();//DB 영구 반영
        em.clear();
    }

    @Test
    void test1(){
        Member member = em.find(Member.class, 1L);
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);

        System.out.println(member == member2); // 주소 같음
        System.out.println("member" + System.identityHashCode(member));
        System.out.println("member2" + System.identityHashCode(member2));

        member.setUserName("수정임");
//        em.flush();

        Member member3 = em.find(Member.class,1L);
        System.out.println(member3);
    }
}
