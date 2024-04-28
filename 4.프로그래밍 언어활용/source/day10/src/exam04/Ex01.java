package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Box appleBox = new Box();
        appleBox.setItem(new Apple()); //생성과 동시에 사과 담기

        //Object apple = appleBox.getItem(); //Box의 반환값은 Object
        //명시적 형변환
        Apple apple = (Apple)appleBox.getItem(); //apple에 있는 함수를 쓰기위해
        System.out.println(apple.get());

        Box grapeBox = new Box();
        grapeBox.setItem(new Grape()); //매개변수 자료형 Object라 모든 형태의 자료형 담을 수 있다.
        Grape grape = (Grape)grapeBox.getItem();
        System.out.println(grape.get());


    }
}
