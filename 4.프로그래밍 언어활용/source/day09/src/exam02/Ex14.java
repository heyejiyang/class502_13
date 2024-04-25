package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex14 {
    public static void main(String[] args) {
        String str1 = "https://www.naver.com";
        String str2 = "ftp://www.naver.com";

        Pattern p1 = Pattern.compile("\\w*(?=:)"); //:기준으로 앞에있는애
        Matcher m1 = p1.matcher(str2);

        if(m1.find()){
            System.out.println(m1.group()); //str1 -> https/ str2 -> ftp
        }
    }
}
