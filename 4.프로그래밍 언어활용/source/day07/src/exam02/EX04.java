package exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EX04 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
            System.out.println("파일 작업 ...");

            System.out.println("자원해제 완료");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                }
            }
        }

        System.out.println("중요한코드쟈냐");
    }
}
