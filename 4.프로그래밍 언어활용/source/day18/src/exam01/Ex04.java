package exam01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex04 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss E");

        LocalDateTime startDate = LocalDateTime.of(2024,3,19,9,0);

        //형식화된 문자열로
        String strDate = formatter.format(startDate);
        System.out.println(strDate); //2024.03.19 09:00:00 화
    }
}
