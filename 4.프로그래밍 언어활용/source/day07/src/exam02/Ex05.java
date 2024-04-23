package exam02;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("a.txt")){
            //FileInputStream은 AutoCloseable 상속받고있음

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
