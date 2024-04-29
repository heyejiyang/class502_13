package exam02;

import java.util.List;

public class Juice {
    public static void make(Basket<?> basket) {
        List<?> items = basket.getItems(); //꺼내기
        System.out.println(items);
    } //Object포함 모든 클래스

}