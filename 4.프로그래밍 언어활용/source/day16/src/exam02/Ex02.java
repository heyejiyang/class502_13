package exam02;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //System.out.println(cal);

        //int year = cal.get(Calendar.YEAR);
        // int month = cal.get(Calendar.MONTH); //  0 ~ 11
        //int day = cal.get(Calendar.DAY_OF_MONTH);
        // System.out.printf("year=%d, month=%d, day=%d%n",year,month+1,day);
        //year=2024, month=5, day=7

        printDate(cal); //year=2024, month=5, day=7

        cal.set(Calendar.MONTH,0); //1월, 원래 객체의 값을 변경
        printDate(cal); //year=2024, month=1, day=7
    }

    public static void printDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); //  0 ~ 11
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.printf("year=%d, month=%d, day=%d%n", year, month + 1, day);
    }
}
