package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex13 {
    public static void main(String[] args) {
        String str = "홍길동: 010-1111-1111\n김수한: 010-2222-3333";
        Pattern p1 = Pattern.compile("([^:]+):\\s*(01[016]\\D*\\d{3,4}\\D*\\d{4})");
        Matcher m1 = p1.matcher(str);

        while(m1.find()){
            System.out.printf("이름:%s,전화번호:%s%n",m1.group(1).replace("\n",""),m1.group(2));
        }
    }
}
