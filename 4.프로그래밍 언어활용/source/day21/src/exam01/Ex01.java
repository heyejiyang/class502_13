package exam01;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {

        //기반스트림
        try(FileOutputStream fos = new FileOutputStream("test1.txt");
            DataOutputStream dos = new DataOutputStream(fos)){
            dos.writeByte(100);
            dos.writeChar('A');
            dos.writeUTF("안녕하세요.");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
