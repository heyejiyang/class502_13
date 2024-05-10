package Exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        //ABCDEFGHIJKLMNOP

        try(FileInputStream fis = new FileInputStream("test1.txt")){

            byte[] buffer = new byte[5];
            while (fis.available()>0){
                int ch = fis.read(buffer);
                //데이터 전체가 5바이트씩 버퍼에 담겨지게 된다.

                for(int i = 0; i< ch; i ++){
                    System.out.print((char)buffer[i]);
                   /*ABCDE
                     FGHIJ
                     KLMNO
                     P
                    */
                }
                //버퍼를 비우는것도 일을 더 해야하는것이기 때문에 버퍼를 비우지 않고 기존값을 순서대로 덮어씌운다.
                //따라서 K자리에 P가 들어가고 나머지 자리 값은 없으니 그 전 값이 남아있다
                System.out.println();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
