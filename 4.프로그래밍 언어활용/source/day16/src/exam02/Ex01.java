package exam02;

import java.util.Date;

public class Ex01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        //Tue May 07 16:39:36 KST 2024

        int year = date.getYear();
        int month = date.getMonth(); //0 ~ 11
        System.out.printf("year=%d, month=%d%n", year, month + 1);
        //year=124, month=5

        long epochTime = date.getTime(); //1970.1.1 자정, 1000

        System.out.println(epochTime); //1715067803128
        //UID(Unique ID)를 만들때 자주 활용
    }
}
