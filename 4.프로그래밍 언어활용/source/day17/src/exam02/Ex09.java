package exam02;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Ex09 {
    public static void main(String[] args) {
        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println(zdt1);
        //2024-05-08T16:16:21.167677200+09:00[Asia/Seoul]

        ZoneId london = ZoneId.of("Europe/London");
        ZonedDateTime londonZdt = zdt1.withZoneSameInstant(london);
        System.out.println(londonZdt);
        //2024-05-08T08:22:09.449156800+01:00[Europe/London]

        ZonedDateTime newYorkZdt = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(newYorkZdt);
        //2024-05-08T03:24:02.416291400-04:00[America/New_York]

        //ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
