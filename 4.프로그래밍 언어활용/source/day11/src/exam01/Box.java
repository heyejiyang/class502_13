package exam01;

public class Box<T extends Fruit & Eatable> { //Fruit, Apple, Grape...
    //T: 타입 //자료형 아직 결정되지 않음, 생성할때 명시된 자료형으로투입
    private T item;

    public void setItem(T item) { //타입 매개변수
        this.item = item;
    }

    public T getItem() { //반환값 타입도 T
        return item;
    }
    public void printInfo(){
        //담겨있는 아이템 정보 확인
        //item.get();//타입은 객체 생성시 정해지기 때문에 여기서 get메서드는 사용 불가능
        //fruit상속 이후
        item.get(); //가능!
    }
}
