public interface Test {
    int add();
    default void met(){
        System.out.println("");
    }
}
