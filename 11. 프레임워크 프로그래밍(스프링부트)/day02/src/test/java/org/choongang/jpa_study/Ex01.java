package org.choongang.jpa_study;

import jakarta.persistence.*;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest //환경변수, 테스트 설정 파일 직접 명시 할 수 있다.
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01 {
    //@Autowired
    //private EntityManagerFactory emf;

    //@Autowired
    @PersistenceContext
    private EntityManager em; //영속성 관리 역할

    @Test
    void test1(){
       // EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        //영속성 관리, member라는 엔티티가 변화감지 상태에 담긴다.
        em.persist(member); //영속 상태 - 변화 감지 메모리에 있다. 변화 감지중

        em.flush(); //insert 쿼리 실행

        em.detach(member); //영속 상태 분리 - 변화 감지 X

        member.setUserName("(수정)사용자01"); //변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); //update 쿼리 실행

        em.merge(member); //분리된 영속 상태를 다시 영속 상태로 바꿔줌(변화 감지 상태)

        em.flush();

      //  em.remove(member); //제거 상태, 제거X, 상태만 제거상태임
       // em.flush(); //delete쿼리 제거상태는 flush 해야지만 제거된다.

//        tx.commit();
    }
}
