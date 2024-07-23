package Level1.solution12916;

public class Solution2 {
    boolean solution(String s) {
        s = s.toUpperCase(); //문자열 전부 대문자로 왜냐.. p,P j,J 소문자와 대문자 같은 형식으로 비교하기 때문에 형식 자체를 소문자나 대문자 중 하나로 변환해도 된다.

        /**
         * 자바는 기본 문자에 대한 문자 스트림을 제공하지 않는다.
         * 각 문자를 정수 스트림으로 변환해야한다.
         * chars() 메서드는 Java의 String 클래스에 포함된 메서드로, 문자열의 각 문자를 정수 스트림(IntStream)으로 변환
         * filter -> 조건에 맞지 않는 요소를 걸러냄
         */
        return s.chars().filter(e -> e == 'P').count() == s.chars().filter(e -> e == 'J').count(); //둘다 없을 경우 0이므로 true됨
    }
}
