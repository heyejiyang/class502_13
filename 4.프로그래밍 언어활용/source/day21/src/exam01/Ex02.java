package exam01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt");
            DataInputStream dis = new DataInputStream(fis)){
            //순서 바뀌면 안됨 할당했던 순서 그대로 !!!
            //write에서 작성한 순서 그대로 읽어야한다.
            byte num = dis.readByte(); //형도 바꿀수없다.
            char ch = dis.readChar();
            String str = dis.readUTF();

            System.out.printf("num=%d, ch=%c, str=%s%n", num, ch, str);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
