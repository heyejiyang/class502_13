package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        //Map 형태로 복구 시키기
        try(FileInputStream fis = new FileInputStream("data.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)){

            HashMap<String,  Object> data = (HashMap<String, Object>) ois.readObject();

            Book book1 = (Book)data.get("book1");
            List<Book> books = (List<Book>) data.get("books");
            //데이터 가져오기

            System.out.println(book1); //Book{isbn=1000, title='책1', author='저자1'}
            books.forEach(System.out::println);
            //Book{isbn=1002, title='책3', author='저자3'}
            //Book{isbn=1003, title='책4', author='저자4'}

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
