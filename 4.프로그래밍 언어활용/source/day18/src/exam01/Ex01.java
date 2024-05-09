package exam01;

import java.time.Instant;

public class Ex01 {
    public static void main(String[] args) {
        //Instant 클래스 현재시간
        Instant today = Instant.now();

        System.out.println(today); //2024-05-09T05:11:34.309613200Z

        long time1 = today.getEpochSecond();//초단위 - TimeStamp
        long time2 = today.toEpochMilli(); //밀리초 단위 - EpochTime

        System.out.printf("time1=%d time2= %d%n", time1, time2);
        //time1=1715231748 time2= 1715231748762
    }
}
