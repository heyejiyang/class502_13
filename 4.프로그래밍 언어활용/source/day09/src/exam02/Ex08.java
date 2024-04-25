package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08 {
    public static void main(String[] args) {
        String str = "AAA\n1234\nBBBB\n456\nCCCCC\nddddddddddd"; //공백도 문자로 생각함

       // Pattern p1 = Pattern.compile("\\b....\\b");//점 하나가 문자 하나를 의미
        // Pattern p1 = Pattern.compile("\\b.{4}\\b"); //4글자 문자 찾기
        Pattern p1 = Pattern.compile("\\b.{4,}\\b"); //4글자 이상
        Matcher m1 = p1.matcher(str);

        while(m1.find()){
            System.out.println(m1.group()); //CCCCC도 출력된다.
        }
//        if(m1.find()){
//            System.out.println(m1.group()); //1234
//        }
//        if(m1.find()){
//            System.out.println(m1.group()); //BBBB
//        }
    }
}
