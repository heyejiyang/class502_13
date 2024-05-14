package exam01;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("score.txt");
            DataInputStream dis = new DataInputStream(fis)){
            int total = 0, cnt = 0;
        try {
            //다읽으면 예외발생
            while (true) {
                int score = dis.readInt();
               total += score;
               cnt++;
            }
        } catch(EOFException e){ //파일을 다 읽은 상태
            System.out.printf("합계: %d, 평균: %.1f",total,total/(double)cnt);
        }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
