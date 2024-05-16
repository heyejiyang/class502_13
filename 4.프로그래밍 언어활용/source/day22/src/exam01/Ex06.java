package exam01;

import java.io.File;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //임시 파일 만들기
        File tmpFile = File.createTempFile("tmp",".log",
                new File("D:/fstudy")); // 파일명,확장자, 파일경로
        //임시파일은 여러개 만들어질 수 있기 때문에 파일명 뒤에 난수가 붙는데 timestamp단위로 붙는다.

        //tmpFile.delete(); //바로 삭제
        tmpFile.deleteOnExit(); //애플리케이션이 종료되면 삭제

        Thread.sleep(5000);//5초 지연
        System.out.println("종료!");
    }
}
