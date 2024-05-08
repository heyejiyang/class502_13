package exam02;

import java.time.LocalTime;

public class Ex07 {
    public static void main(String[] args) {
        LocalTime today = LocalTime.now();
        LocalTime time = LocalTime.of(23,30,0);//시분초

        System.out.println(today); //15:56:08.267343700
        System.out.println(time); //23:30
    }
}
