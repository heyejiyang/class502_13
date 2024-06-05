package exam01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("테스트클래스올시다...")
public class Ex01Test {

    @Test
    @DisplayName("테스트1 덧셈이올시다.")
    void test1(){
        Calculator cal = new Calculator();
        int num1 = 10, num2 = 20;
        int result = cal.add(num1,num2);
        assertEquals(30,result); //테스트 통과
    }

    @Test
    @Disabled
    @DisplayName("테스트2 동일성 비교이올시다...")
    void test2(){
        LocalDate expected = LocalDate.now();
        LocalDate date = LocalDate.of(2024,6,5);
        //assertEquals(expected,date); //동등성 비교
        assertSame(expected,date); //동일성 비교 - 테스트 failed
    }

    @Test
    @Disabled
    @DisplayName("테스트3 fail 그 잡채올시다..")
    void test3(){
        fail();//무조건 실패!
    }
}
