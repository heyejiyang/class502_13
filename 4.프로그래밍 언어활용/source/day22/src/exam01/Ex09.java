package exam01;

import java.io.*;
import java.lang.ref.Cleaner;

public class Ex09 {
    public static void main(String[] args) {
        //객체형태로 다시 복구하기
        try(FileInputStream fis = new FileInputStream("book.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Book book1 = (Book)ois.readObject(); //반환값 Object
            System.out.println(book1);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
