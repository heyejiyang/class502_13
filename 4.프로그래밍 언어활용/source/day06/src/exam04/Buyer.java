package exam04;

public interface Buyer {
    void buy();
    default void method(){
        System.out.println("구매");
    }
}
