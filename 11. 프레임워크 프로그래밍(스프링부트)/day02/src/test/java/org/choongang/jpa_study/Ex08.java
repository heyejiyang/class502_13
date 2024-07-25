package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
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

@SpringBootTest
@ActiveProfiles("test") //@TestPropertySource(properties = "spring.profiles.active=test")

@Transactional
public class Ex08 {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

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

        em.clear(); //영속성 안에 엔티티 비우기 - select 실행시키도록
    }
    @Test
    void test1(){
        Member member = memberRepository.findById(1L).orElse(null);
        System.out.println(member);

        member.setUserName("flush 생략 테스트");

        List<Member> members = memberRepository.findAll(); //모두조회
        members.forEach(System.out::println);
    }

}
