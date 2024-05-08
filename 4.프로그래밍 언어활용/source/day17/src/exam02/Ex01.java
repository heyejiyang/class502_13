package exam02;

import java.time.LocalDate;

public class Ex01 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); //현재시각
        System.out.println(today); //2024-05-08

        LocalDate date = LocalDate.of(2023,5,8);
        System.out.println(date); //2023-05-08
    }
}
