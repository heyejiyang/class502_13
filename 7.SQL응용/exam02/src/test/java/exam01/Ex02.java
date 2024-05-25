package exam01;

import member.Board;
import member.Member;
import member.User;
import member.User2;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Ex02 {
    @Test
    void test1(){
        Member member = new Member("user1","사용자02");
        System.out.println(member);
    }
    @Test
    void test2(){
        Board board = new Board("제목","내용");
        System.out.println(board);
    }

    @Test
    void test3(){
        //User user = new User(); 객체 생성불가
        User user = User.builder().userId("USER01").userNm("사용자01").email("USER01@test.org").regDt(LocalDateTime.now()).build();

        System.out.println(user);
    }

    @Test
    void test4(){
        User2 user = User2.builder().userId("USER02").userNm("사용자02").email("USER02@test.org").regDt(LocalDateTime.now()).build();
        System.out.println(user);

        User2 user2 = new User2();
    }
}
