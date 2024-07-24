package org.choongang.jpa_study;

import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
//레포지토리할때 트랜잭셔널을 하지 않아도 내부적으로 해줌
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05 {
    // 레포지토리 가져와서 엔티티에 해당하는 쿼리 수행

    @Autowired
    private MemberRepository memberRepository; //인터페이스만 정의해도 구현체가 만들어짐 - 프록시

    @BeforeEach
    void init(){
        List<Member> members = IntStream.rangeClosed(1,10)
                .mapToObj(i -> Member.builder()
                        .email("user"+i+"@test.org")
                        .password("12341234")
                        .userName("사용자"+i)
                        .authority(Authority.USER)
                        .build()).toList();
        memberRepository.saveAllAndFlush(members);

        /*for(int i = 1; i<= 10; i++) {
            Member member = Member.builder()
                    .email("user"+i+"@test.org")
                    .password("12341234")
                    .userName("사용자"+i)
                    .authority(Authority.USER)
                    .build();

            memberRepository.save(member);
            //memberRepository.saveAndFlush(member); //save(persist) + flush
            //memberRepository.flush(); //DB반영

        }*/
    }

    @Test
    void test1(){
        //조회
        Member member = memberRepository.findById(1L).orElse(null); //optinal 형태이기 때문에 대체 값 지정
        System.out.println(member);

        member.setUserName("수정용용");
        memberRepository.save(member);
        //memberRepository.flush();
        Member member2 = memberRepository.findById(1L).orElse(null);
        System.out.println(member2);

        memberRepository.delete(member2);
        memberRepository.flush();
    }

    @Test
    void test2(){
        List<Member> members = memberRepository.findAll();
        members.forEach(System.out::println);
    }
}
