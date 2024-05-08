package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
public class EX05 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.with(ChronoField.YEAR, 2023);

        System.out.println("변경 x: "+ today); //변경 x: 2024-05-08
        System.out.println("변경 o: "+ lastYear); //변경 o: 2023-05-08
    }
}
