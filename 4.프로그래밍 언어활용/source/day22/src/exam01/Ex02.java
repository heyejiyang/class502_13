package exam01;

import java.io.IOException;
import java.io.PrintStream;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream("20240516.log");
        System.setErr(out);//에러 출력스트림은 20240516.log파일로 기록될것이다

        String str = null;
        str.toUpperCase(); //에러 발생시키기
        //20240516.log로 출력될것이다.

    }
}
