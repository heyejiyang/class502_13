package exam01;

import java.util.Calendar;

public class Ex01 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        printDate(cal);//year=2024, month=5, day=8

        //cal.set(Calendar.MONTH,11); //12월 (0~11)
        //printDate(cal); //year=2024, month=12, day=8

        cal.add(Calendar.DAY_OF_MONTH,150); //150일후
        printDate(cal); //year=2024, month=10, day=5

        cal.add(Calendar.DAY_OF_MONTH, - 100); //100일 전
        printDate(cal); //year=2024, month=6, day=27
    }
    public static void printDate(Calendar cal){
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0 ~ 11, 1월 -> 0
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.printf("year=%d, month=%d, day=%d%n", year, month+1, day);
    }
}
