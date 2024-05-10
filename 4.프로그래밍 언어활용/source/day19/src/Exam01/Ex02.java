package Exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")){
            //ABCDE
            //파일쪽에 위치한 글자 하나씩 읽어옴
            int ch = fis.read(); //1바이트 읽기
            System.out.println((char) ch); //A -> 정수로는 65
            ch = fis.read(); //1바이트
            System.out.println((char)ch); //B -> 66
            ch = fis.read(); //1바이트
            System.out.println((char)ch); //C
            ch = fis.read(); //1바이트
            System.out.println((char)ch); //D
            ch = fis.read(); //1바이트
            System.out.println((char)ch); //E

            // 다 읽고나서 한번 더 출력해보면 이상한거 출력된다!!
            ch = fis.read(); //1바이트
            System.out.println(ch); //숫자로 -1 출력 나옴
            // 파일을 전부 다 읽음을 나타냄
            System.out.println((char)ch);  //￿ ??

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
