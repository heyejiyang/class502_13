package Exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt")){
            while (fis.available() > 0){
                System.out.print((char)fis.read()); //ABCDE
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
