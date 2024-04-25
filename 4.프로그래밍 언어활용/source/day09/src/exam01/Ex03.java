package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("data.txt"));
        //"data.txt" 파일을 읽기 위한 Scanner 객체를 생성
        //파일이 없을 경우 FileNotFoundException이 발생할 수 있으므로 예외처리가 필요

        /* data.txt에 100,200,300,400,500 작성*/
        int total = 0;
        while(scan.hasNextInt()){
            //파일에서 읽을 정수가 남아있는 동안에만 반복하는 while 루프를 시작
            //hasNextInt() 메서드는 입력 스트림에서 다음 토큰이 정수로 해석될 수 있는지 여부를 확인
            int num = scan.nextInt(); //파일에서 정수 읽어옴
            total += num;
        }
        System.out.println(total);
    }
}
