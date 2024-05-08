package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ex06 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        today.plus(150, ChronoUnit.DAYS);
        System.out.println(today); //2024-05-08
        // 불변성 기존꺼 바꾸지 않는다! 기존꺼를 유지하면서 새로운 객체에 반환

        LocalDate date2 = today.plus(150,ChronoUnit.DAYS);
        System.out.println("150일 이후: "+ date2); //150일 이후: 2024-10-05

        LocalDate date3 = today.minus(150, ChronoUnit.DAYS);

        System.out.println("150일 전:" + date3); //150일 전:2023-12-10
    }
}
