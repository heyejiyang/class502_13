package exam01;

import java.time.Duration;
import java.time.LocalTime;

public class Ex03 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime endTime = LocalTime.of(17,50);

        Duration du = Duration.between(now,endTime);
       // System.out.println(du); //PT3H16M36.1155015S
        long seconds = du.getSeconds();
        //System.out.println(seconds); //11718

        LocalTime time = LocalTime.of(0,0,0);
        LocalTime time2 = time.plusSeconds(seconds);
        int hours = time2.getHour();
        int minutes = time2.getSecond();
        System.out.printf("수업 종료까지 %d 시간 %d분 %d초 남았습니다.%n",
                hours,minutes,seconds);
        //수업 종료까지 3 시간 54분 11454초 남았습니다.


    }
}
