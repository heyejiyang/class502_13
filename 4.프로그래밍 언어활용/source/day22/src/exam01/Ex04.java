package exam01;

import java.io.File;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        //File file = new File("D:/test1.txt");//파일 경로
        //file.createNewFile(); //비어있는 파일 생성
        File dir = new File("D:/fstudy"); //디렉토리
        File file = new File(dir, "test1.txt"); //파일명

        if(!dir.exists()){ //디렉토리가 없는경우 디렉토리 만들기
            dir.mkdir();
        }

        file.createNewFile();
    }
}
