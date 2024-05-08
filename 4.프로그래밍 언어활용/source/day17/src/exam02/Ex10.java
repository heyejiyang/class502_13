package exam02;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Ex10 {
    public static void main(String[] args) {
        OffsetDateTime odt1 = OffsetDateTime.now();
        ZoneOffset london = ZoneOffset.of("+1");

        OffsetDateTime londonOdt = odt1.withOffsetSameInstant(london);
        System.out.println(londonOdt);
        //2024-05-08T08:31:08.249511600+01:00
    }
}
