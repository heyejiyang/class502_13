package exam01;

public class Ex03 {
    public static void main(String[] args) {
        //생성자 private 상태
        Book book = Book.builder().title("책1").author("저자1").publisher("출판사1").build();


        System.out.println(book); //Book{title='책1', author='저자1', publisher='출판사1'}
    }
}
