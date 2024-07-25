package org.choongang.jpa_study;

import org.choongang.member.entites.Member;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01 {
//    @Autowired
//    private EntityManagerFactory emf;

    @PersistenceContext //엔티티 매니저 팩토리를 통해 엔티티 매니저를 자동으로 생성하고 주입
    private EntityManager em; //영속성 관리역할

    @Test
    void test1(){
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();

        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);

        em.flush(); //insert쿼리 실행

        em.detach(member);

        member.setUserName("수정수정장성준");
        member.setModifiedAt(LocalDateTime.now());

        em.flush();

        em.merge(member);
        em.flush();
//
//        em.remove(member);
//
//        em.flush();

//        tx.commit();
    }
}
