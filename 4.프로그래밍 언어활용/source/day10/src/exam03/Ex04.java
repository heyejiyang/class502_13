package exam03;

@Todo("할일1") //Repeatable이라 여러개를 반복해서 담을 수 있다.
@Todo("할일2") //값조회는 Todos에서
@Todo("할일3")
public class Ex04 {
    public static void main(String[] args) {
        Class cls = Ex04.class;
        Todos todos = (Todos) cls.getAnnotation(Todos.class);
        Todo[] todo = todos.value();

        for (Todo t : todo) {
            System.out.println(t.value()); //할일1, 할일2, 할일3
        }
    }
}
