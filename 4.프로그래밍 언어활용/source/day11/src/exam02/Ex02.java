package exam02;

import exam01.Fruit;
import exam01.Grape;

public class Ex02 {
    public static void main(String[] args) {
        Basket<Grape> grapeBox = new Basket<>();
        grapeBox.add(new Grape());
        grapeBox.add(new Grape());

        Juice.make(grapeBox);
    }
}
