package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test2.txt");
            InputStreamReader isr = new InputStreamReader(fis)){
            int ch = 0;
            while ((ch = isr.read()) != -1){ //읽을 바이트가 있을때까지
                System.out.print(ch); //문자형태로 읽어옴
                //ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ
                //íì´ë£¨ 한글은 깨져서 나옴ㅜㅜ
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
