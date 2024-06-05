package exam01;

import org.junit.jupiter.api.*;

public class Ex02Test {

    @BeforeAll
    static void beforeAllM(){
        System.out.println("나는야 BeforeAll이다.");
    }
    @AfterAll
    static void afterAllM(){
        System.out.println("나는야 AfterAll이다 !!");
    }

    @BeforeEach //각각 단위 테스트 메서드 실행 전 실행
    void beforEachMethod(){
        System.out.println("BEFORE EACH");
    }

    @AfterEach // 각각 단위 테스트 메서드 실행 후 실행
    void afterEach(){
        System.out.println("AFTER EACH");
    }
    @Test
    void test1(){
        System.out.println("테스트 1번 진행");
    }
    @Test
    void test2(){
        System.out.println("테스트 2번 진행");
    }
}
