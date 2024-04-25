package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07 {
    public static void main(String[] args) {
        String str = "junione one \njuni two\njuni three";
        //System.out.println(str); //세줄로 출력
        //Pattern p1 = Pattern.compile("^\\w+\\s");// 첫번째 juni를 원함
        //juni를 다 찾으려고하는데 줄개행 표시때문에 못찾음
        // - 기본적으로 한줄에 있는거 찾기 때문 -> flag이용하기

        //여러줄에 걸쳐 패턴 체크
        Pattern p1 = Pattern.compile("^\\w+\\s",Pattern.MULTILINE);
        Matcher m1 = p1.matcher(str);
        if(m1.find()){
            System.out.println(m1.group()); //첫번째 juni
        }if(m1.find()){
            System.out.println(m1.group());
        }if(m1.find()){
            System.out.println(m1.group());
        }
    }
}
