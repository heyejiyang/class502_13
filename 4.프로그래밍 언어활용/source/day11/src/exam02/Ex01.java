package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Basket<Apple> appleBasket = new Basket<>();
        appleBasket.add(new Apple()); //사과담기
        appleBasket.add(new Apple());

        Juice.make(appleBasket);
    }
}
