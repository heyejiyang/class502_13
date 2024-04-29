package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        // 자료형 Apple로 명시 박스에 Apple만 들어가도록

        appleBox.setItem(new Apple()); // 다른 자료형 들어갈 수 없음

        //형변환 필요없음
        Apple apple = appleBox.getItem();
        System.out.println(apple.get());

        //Box<Grape> grapeBox = new Box<>(); //Grape만 들어가는 박스
        //grapeBox.setItem(new Grape());

        //Grape grape = grapeBox.getItem();
        //System.out.println(grape.get());


    }
}
