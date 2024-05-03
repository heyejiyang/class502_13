package exam01;

import java.util.Optional;

public class Ex08 {
    public static void main(String[] args) {
        String str = null;
        //Optional<String> opt = Optional.of(str); //null일때 오류 발생
        // System.out.println(opt.get()); //안에 있는 값 꺼내기
        //ABC
        //null 일경우 오류...at java.base/java.util.Objects.requireNonNull ...
        Optional<String> opt = Optional.ofNullable(str); //null 허용
        // System.out.println(opt.get()); //null이면 예외발생 처리해준다 NosuchElementException 발생
        //No value present
        String value = opt.orElse("기본값");
        System.out.println(value); //기본값 대체 출력

    }
}
