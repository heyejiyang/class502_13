package exam01;

import member.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Ex01 {

    @Test
   void test1(){
       Member m = new Member();
       m.setUserId("user01");
       m.setUserNm("사용자01");
       m.setEmail("user01@test.org");
       m.setRegDt(LocalDateTime.now());

        System.out.println(m);
   }

   @Test
   void test2(){
       Member m1 = new Member();
       m1.setUserId("user01");
       m1.setUserNm("사용자01");
       m1.setEmail("user01@test.org");
       m1.setRegDt(LocalDateTime.now());

       Member m2 = new Member();
       m2.setUserId("user01");
       m2.setUserNm("사용자01");
       m2.setEmail("user01@test.org");
       m2.setRegDt(LocalDateTime.now());

       System.out.println(m1.equals(m2)); //true
       System.out.println(m1.hashCode());
       System.out.println(m2.hashCode()); //해쉬코드 같음
   }
}
