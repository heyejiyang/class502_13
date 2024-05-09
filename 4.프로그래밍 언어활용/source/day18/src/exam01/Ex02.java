package exam01;

import java.time.LocalDate;
import java.time.Period;

public class Ex02 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2024,9,30);

        Period period = Period.between(today,endDate);
        //System.out.println(period); //P-4M-21D / 4개월 20일

        int month = period.getMonths();
        int day = period.getDays();
        System.out.printf("남은 수업: %d개월, %d일%n",month, day);
        //남은 수업: 4개월, 21일
    }
}
