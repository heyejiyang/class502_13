package exam01;

import java.io.File;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/fstudy/sub1/sub2/sub3/test1.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath); //D:\fstudy\sub1\sub2\sub3\test1.txt

        //D:/fstudy/test1.txt 와 동일
        File file2 = new File("D:/fstudy/sub1/sub2/sub3/../../../test1.txt");
        //상대경로가 중간에 포함된 경우

        //절대경로 확인
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath2); //D:\fstudy\sub1\sub2\sub3\..\..\..\test1.txt


        //상대경로를 절대경로로 바꿔준다.
        String canonicalPath = file2.getCanonicalPath();
        System.out.println(canonicalPath); //D:\fstudy\test1.txt


        System.out.println("getName(): "+ file.getName());
        //getName(): test1.txt
        System.out.println("getPath(): "+ file.getPath());
        //getPath(): D:\fstudy\sub1\sub2\sub3\test1.txt
    }

}
