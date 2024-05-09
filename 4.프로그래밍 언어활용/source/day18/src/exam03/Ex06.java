package exam03;

import java.text.MessageFormat;

public class Ex06 {
    public static void main(String[] args) {
        String pattern = "이름:{0}, 전화번호:{1}"; //순서대로 입력하면 데이터가 각각 채워진다.

        String[] names = {"이이름", "김이름", "최이름"};
        String[] mobiles = {"010-0000-0000", "010-1000-1000",
                "010-2000-2000"};

        for (int i = 0; i < names.length; i++) {
            String str = MessageFormat.format(pattern, names[i], mobiles[i]); //names는 0번째 mobiles는 1번째 ... 순서대로 입력
            System.out.println(str);
        }
        /*이름:이이름, 전화번호:010-0000-0000
          이름:김이름, 전화번호:010-1000-1000
          이름:최이름, 전화번호:010-2000-2000*/
    }
}
