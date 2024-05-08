package exam02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex08 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime today2 = today.atTime(LocalTime.now());
        //날짜와 시간 둘 다 표기
        System.out.println(today2); //2024-05-08T16:00:35.338492600
    }
}
