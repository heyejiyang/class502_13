package exam04;

public interface Seller {
    void sell();
    default void method(){
        System.out.println("판매");
    }
}
