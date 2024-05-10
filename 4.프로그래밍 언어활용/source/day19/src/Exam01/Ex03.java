package Exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")){
            int ch = 0;

            //-1이 나오면 파일 다 읽은 것
            while ((ch = fis.read()) != -1){
                System.out.print((char)ch);
                /*ABCDE*/
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
